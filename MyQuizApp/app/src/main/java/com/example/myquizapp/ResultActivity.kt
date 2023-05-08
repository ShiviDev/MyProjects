package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvname:TextView=findViewById(R.id.tv_name)
        val tvScore:TextView=findViewById(R.id.tv_score)
        val btn:Button =findViewById(R.id.btn_finish)

        tvname.text=intent.getStringExtra((Constants.USER_NAME))

        val totalQuestion=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers=intent.getIntExtra(Constants.CORRECT_ANSWER,0)

        tvScore.text="Your Score is $correctAnswers out of $totalQuestion"
        btn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}