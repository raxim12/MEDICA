package com.example.medica

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class SignInActivity : AppCompatActivity() {
    private lateinit var signInButton: TextView
    private lateinit var emailEditText: EditText
    private lateinit var emailLayout: ConstraintLayout
    private lateinit var emailIcon: ImageView

    private lateinit var passwordEditText: EditText
    private lateinit var passwordLayout: ConstraintLayout
    private lateinit var passwordIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)

        // Elementlarni topamiz
        signInButton = findViewById(R.id.buttonSignUp)
        emailEditText = findViewById(R.id.emailEditText)
        emailLayout = findViewById(R.id.email)
        emailIcon = findViewById(R.id.mail)

        passwordEditText = findViewById(R.id.passwordEditText)
        passwordLayout = findViewById(R.id.password)
        passwordIcon = findViewById(R.id.lock)

        // Email uchun listener
        setEditTextListener(emailEditText, emailLayout, emailIcon)

        // Parol uchun listener
        setEditTextListener(passwordEditText, passwordLayout, passwordIcon)

        // Sign Up tugmasi
        signInButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setEditTextListener(
        editText: EditText,
        layout: ConstraintLayout,
        icon: ImageView
    ) {
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                layout.setBackgroundResource(R.drawable.edit_bg_active)
                icon.setColorFilter(getColor(R.color.basic_color)) // Ikon rangini o'zgartiradi
            } else if (editText.text.isEmpty()) {
                layout.setBackgroundResource(R.drawable.edit_bg)
                icon.setColorFilter(getColor(R.color.grey))
            }
        }

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Matn yozilganda biror maxsus harakat kerak bo‘lsa, bu yerda qo‘shishingiz mumkin
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
