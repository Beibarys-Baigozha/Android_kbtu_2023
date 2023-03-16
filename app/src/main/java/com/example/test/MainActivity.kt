package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonToSignUp: Button = findViewById(R.id.button_to_sign_up)
        buttonToSignUp.setOnClickListener() {
            intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val buttonToSignIn: Button = findViewById(R.id.button_to_sign_in)
        buttonToSignIn.setOnClickListener() {
            intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}

