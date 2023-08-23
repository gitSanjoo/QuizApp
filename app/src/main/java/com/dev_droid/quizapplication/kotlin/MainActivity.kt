package com.dev_droid.quizapplication.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.dev_droid.quizapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed(3000){

            if(FirebaseAuth.getInstance().currentUser!=null){
                val intent= Intent(this,QuizActivity::class.java)
                startActivity(intent)
            }else {
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("MODE","SIGNUP")
                startActivity(intent)
            }
        }
    }
}