package com.example.medica

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var signInButton: Button
    private lateinit var signUpButton: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        signInButton = findViewById(R.id.buttonSignIn)
        signUpButton = findViewById(R.id.buttonSignUp)
        signInButton.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
        signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }


    }
}