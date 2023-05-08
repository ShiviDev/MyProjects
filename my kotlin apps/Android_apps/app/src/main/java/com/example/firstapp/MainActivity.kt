package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mybutton = findViewById<Button>(R.id.mybutton)
        val mytext=findViewById<TextView>(R.id.myText)
        var count =0
        mybutton.setOnClickListener {
           count+=1
            mytext.text=count.toString()
            Toast.makeText(this,"Hey I'm a toast!", Toast.LENGTH_SHORT).show()
        }

    }
}