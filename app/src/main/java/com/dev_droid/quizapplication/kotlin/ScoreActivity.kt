package com.dev_droid.quizapplication.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dev_droid.quizapplication.R
import com.dev_droid.quizapplication.databinding.ActivityQuizBinding
import com.dev_droid.quizapplication.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    lateinit var binding:ActivityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_score)

        binding.scoreTv.setText("your score is : ${intent.getIntExtra("SCORE",0)}")
    }
}