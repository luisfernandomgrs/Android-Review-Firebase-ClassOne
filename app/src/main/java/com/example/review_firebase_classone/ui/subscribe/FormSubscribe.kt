package com.example.review_firebase_classone.ui.subscribe

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.review_firebase_classone.R
import com.example.review_firebase_classone.databinding.ActivityFormSubscribeBinding

class FormSubscribe : AppCompatActivity() {
    lateinit var binding : ActivityFormSubscribeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityFormSubscribeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}