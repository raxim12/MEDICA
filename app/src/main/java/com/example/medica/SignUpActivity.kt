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
import androidx.core.content.ContextCompat

class SignUpActivity : AppCompatActivity() {
    private lateinit var signUpButton: TextView
    private lateinit var emailEditText: EditText
    private lateinit var emailLayout: ConstraintLayout
    private lateinit var emailIcon: ImageView

    private lateinit var passwordEditText: EditText
    private lateinit var passwordLayout: ConstraintLayout
    private lateinit var passwordIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        // Elementlarni topamiz
        signUpButton = findViewById(R.id.buttonSignIn)
        emailEditText = findViewById(R.id.emailEditText)
        emailLayout = findViewById(R.id.email)
        emailIcon = findViewById(R.id.ic_email)

        passwordEditText = findViewById(R.id.passwordEditText)
        passwordLayout = findViewById(R.id.password)
        passwordIcon = findViewById(R.id.ic_password)

        // Listenerlarni sozlash
        setEditTextListener(emailEditText, emailLayout, emailIcon)
        setEditTextListener(passwordEditText, passwordLayout, passwordIcon)

        // SignInActivity ga o'tish
        signUpButton.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
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
                icon.setColorFilter(ContextCompat.getColor(this, R.color.basic_color))
            } else if (editText.text.isEmpty()) {
                layout.setBackgroundResource(R.drawable.edit_bg)
                icon.setColorFilter(ContextCompat.getColor(this, R.color.grey))
            }
        }

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Agar yozish davomida biror harakat kerak bo‘lsa
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
