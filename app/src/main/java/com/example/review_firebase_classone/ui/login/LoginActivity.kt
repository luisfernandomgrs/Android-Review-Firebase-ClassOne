package com.example.review_firebase_classone.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.review_firebase_classone.R
import com.example.review_firebase_classone.databinding.ActivityLoginBinding
import com.example.review_firebase_classone.ui.subscribe.FormSubscribe

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.linkToSubscribeForm.setOnClickListener {
            var intent = Intent(this, FormSubscribe::class.java)
            startActivity(intent)
        }
    }
}