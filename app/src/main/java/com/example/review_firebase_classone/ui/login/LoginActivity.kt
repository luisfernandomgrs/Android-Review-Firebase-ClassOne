package com.example.review_firebase_classone.ui.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.review_firebase_classone.R
import com.example.review_firebase_classone.databinding.ActivityLoginBinding
import com.example.review_firebase_classone.ui.MainActivity.MainActivity
import com.example.review_firebase_classone.ui.subscribe.FormSubscribe
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.linkToSubscribeForm.setOnClickListener {
            var intent = Intent(this, FormSubscribe::class.java)
            startActivity(intent)
        }

        binding.buttonLogin.setOnClickListener { view ->
            val edit_email = binding.editEmail.text.toString()
            val edit_password = binding.editPassword.text.toString()

            if (edit_email.isEmpty() || edit_password.isEmpty()) {
                val snackbar = Snackbar.make(view, "It's necessary that fill all fields!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {
                auth.signInWithEmailAndPassword(edit_email, edit_password).addOnCompleteListener { authResult ->
                    if (authResult.isSuccessful) {
                        val intentMainActivity = Intent(this, MainActivity::class.java)
                        startActivity(intentMainActivity)

                        // In this context, is recommended to finish the current context, because you don't need more of this activity
                        finish()
                    }
                }.addOnFailureListener {
                    val snackbar = Snackbar.make(view, "Account User Login, Failure", Snackbar.ANIMATION_MODE_SLIDE)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        val currentUser = FirebaseAuth.getInstance().currentUser

        if (currentUser != null) {
            val intentMainActivity = Intent(this, MainActivity::class.java)
            startActivity(intentMainActivity)

            // In this context, is recommended to finish the current context, because you don't need more of this activity
            finish()
        }
    }
}