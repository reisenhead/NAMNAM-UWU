package com.example.namnam_uwu.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.namnam_uwu.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        Handler().postDelayed({
            val intent = Intent(this@MainActivity , LoginScreen::class.java)
            //val intent = Intent(this@MainActivity , RegisterScreen::class.java)
            startActivity(intent)
            finish()
        }, 1000)



    }
}