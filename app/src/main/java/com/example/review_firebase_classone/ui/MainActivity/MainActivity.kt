package com.example.review_firebase_classone.ui.MainActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.review_firebase_classone.R
import com.example.review_firebase_classone.databinding.ActivityLoginBinding
import com.example.review_firebase_classone.databinding.ActivityMainBinding
import com.example.review_firebase_classone.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.fabLogoutAction.setOnClickListener { view ->
            FirebaseAuth.getInstance().signOut()

            val intentLoginActivity = Intent(this, LoginActivity::class.java)
            startActivity(intentLoginActivity)

            // In this context, is recommended to finish the current context, because you don't need more of this activity
            finish()
        }
    }
}