package com.example.review_firebase_classone.ui.subscribe

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.review_firebase_classone.R
import com.example.review_firebase_classone.databinding.ActivityFormSubscribeBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import kotlinx.coroutines.handleCoroutineException

class FormSubscribe : AppCompatActivity() {
    lateinit var binding : ActivityFormSubscribeBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityFormSubscribeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener { view ->
            val edit_email = binding.editEmail.text.toString()
            val edit_password = binding.editPassword.text.toString()

            if (edit_email.isEmpty() || edit_password.isEmpty()) {
                val snackbar = Snackbar.make(view, "It's necessary that fill all fields!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }
            else {
                auth.createUserWithEmailAndPassword(edit_email, edit_password).addOnCompleteListener { authResult ->
                    if (authResult.isSuccessful) {
                        // clearing fields after successful subscribe
                        binding.editEmail.setText("")
                        binding.editPassword.setText("")

                        val snackbar = Snackbar.make(view, "User registered successfully", Snackbar.LENGTH_INDEFINITE)
                        snackbar.setBackgroundTint(Color.BLUE)
                        snackbar.show()
                    }
                }.addOnFailureListener { exception ->
                    val messageError = when(exception) {
                        is FirebaseAuthWeakPasswordException -> "Password with 6 or more characters, is required!"
                        is FirebaseAuthInvalidCredentialsException -> "Invalid Email"
                        is FirebaseNetworkException -> "Connection Failed"
                        else -> "Subscribe Failed"
                    }

                    val snackbar = Snackbar.make(view, messageError, Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                }

            }
        }
    }
}