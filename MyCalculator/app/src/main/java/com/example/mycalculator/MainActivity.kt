package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    var lastNumeric: Boolean = false
    var lastDot:Boolean = false
    var tvinput: TextView? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvinput=findViewById<TextView>(R.id.tv_input)
    }
    fun onDigit(view:View){
        tvinput?.append((view as Button).text)
        lastNumeric = true
    //Toast.makeText(this,"Button clicked!",Toast.LENGTH_LONG).show()
    }
    fun onClear(view:View){
        tvinput?.text=""
        lastNumeric=false
        lastDot=false

    }
    fun onDot(view:View)
    {
        if(lastNumeric&&!lastDot)
        {
            lastNumeric=false
            lastDot=true
            tvinput?.append(".")
        }
    }
    fun onOperator(view:View)
    {
        tvinput?.text?.let{
            if(lastNumeric &&!isOperatorAdded(it.toString())){
                tvinput?.append((view as Button).text)
                lastNumeric=false
                lastDot=false
            }
    }
    }
    private fun isOperatorAdded(value:String):Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("+")||
                    value.contains("*")||
                    value.contains("/")||
                    value.contains("-")
        }
    }
    fun removeZeroAfterDot(result:String):String{
        var value = result
        if(result.endsWith(".0"))
            value=result.substring(0,result.length-2)
        return value
    }
    fun onEqual(view: View)
    {
        if(lastNumeric){
           var prefix=""
            var tvValue=tvinput?.text.toString()
            try{
                if(tvValue.startsWith("-"))
                {
                    prefix="-"
                    tvValue=tvValue.substring(1)
                }
                if(tvValue.contains("-")) {
                    val splitValue = tvValue.split("-")

                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    tvinput?.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
                }
                else if(tvValue.contains("+")) {
                    val splitValue = tvValue.split("+")

                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    tvinput?.text = removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())
                }
                else if(tvValue.contains("/")) {
                    val splitValue = tvValue.split("/")

                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    tvinput?.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())
                }
                else {
                    val splitValue = tvValue.split("*")

                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    tvinput?.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())
                }
            }catch(e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }

}