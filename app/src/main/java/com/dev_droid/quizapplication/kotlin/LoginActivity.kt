package com.dev_droid.quizapplication.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev_droid.quizapplication.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

    }
}