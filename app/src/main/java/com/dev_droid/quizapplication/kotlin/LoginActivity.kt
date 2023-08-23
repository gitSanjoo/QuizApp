package com.dev_droid.quizapplication.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dev_droid.quizapplication.R
import com.dev_droid.quizapplication.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        var binding: ActivityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.signUpBtn.setOnClickListener{
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.emailEt.editText?.text.toString(),
            binding.passwordEt.editText?.text.toString()).addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(this,"user created !!!",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"user not created !!!",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}