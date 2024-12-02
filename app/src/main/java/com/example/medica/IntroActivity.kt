package com.example.medica

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intro)

        // Splash Screen 3 soniyadan keyin HomeActivity’ga o‘tadi
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, IntroOneActivity::class.java)
            startActivity(intent)
            finish() // SplashActivity’ni tugatish
        }, 3000) // 3 soniya

    }
}