package com.dev_droid.quizapplication.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.dev_droid.quizapplication.R
import com.dev_droid.quizapplication.databinding.ActivityQuizBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class QuizActivity : AppCompatActivity() {
    private lateinit var binding:ActivityQuizBinding
    private var count:Int=0
    lateinit var list:ArrayList<QuestionModel>
    private var score:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*binding=ActivityQuizBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)*/
        binding=DataBindingUtil.setContentView(this,R.layout.activity_quiz)

        list=ArrayList<QuestionModel>()
        Firebase.firestore.collection("quiz").get().addOnSuccessListener {
            doct->
            list.clear()
            for(i in doct.documents){
                var questionModel=i.toObject(QuestionModel::class.java)
                list.add(questionModel!!)
            }
            binding.tvQuestion.setText(list.get(0).question)
            binding.button.setText(list.get(0).option1)
            binding.button2.setText(list.get(0).option2)
            binding.button3.setText(list.get(0).option3)
        }


//        list.add(QuestionModel("what is your fvrt color ?","red","black","green","red"))
//        list.add(QuestionModel("what is your fvrt color ?","white","black","green","white"))
//        list.add(QuestionModel("what is your fvrt color ?","yellow","black","green","yellow"))
//        list.add(QuestionModel("what is your fvrt color ?","red","black","green","red"))
//        list.add(QuestionModel("what is your fvrt color ?","white","black","green","white"))

if(list.size>0) {

}

        binding.button.setOnClickListener{
             nextData(binding.button.text.toString())
        }
        binding.button2.setOnClickListener{
            nextData(binding.button2.text.toString())
        }
        binding.button3.setOnClickListener{
            nextData(binding.button3.text.toString())
        }


    }

    private fun nextData(i: String) {
        if(count<list.size){
        if(list.get(count).ans.equals(i)){score++ }}

        count++
        if(count>=list.size){
                val intent= Intent(this,ScoreActivity::class.java)
            intent.putExtra("SCORE",score)
            startActivity(intent)
        }else {
            binding.tvQuestion.setText(list.get(count).question)
            binding.button.setText(list.get(count).option1)
            binding.button2.setText(list.get(count).option2)
            binding.button3.setText(list.get(count).option3)
        }
    }
}