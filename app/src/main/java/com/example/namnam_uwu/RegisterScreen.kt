package com.example.namnam_uwu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_screen.*

class RegisterScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)

        supportActionBar?.hide()

        /*
        iniciaSesionButton.setOnClickListener {
            val intent = Intent(this@RegisterScreen , LoginScreen::class.java )
            startActivity(intent)
        }

         */
    }
}