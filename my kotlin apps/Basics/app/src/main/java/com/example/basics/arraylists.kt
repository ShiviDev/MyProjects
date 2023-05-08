package com.example.basics

fun main(){
    val numbers : ArrayList<Double> = ArrayList<Double>()
    numbers.add(12.2)
    numbers.add(20.4)
    numbers.add(3.5)
    numbers.add(32.2)
    numbers.add(13.0)
    var x:Double=0.0
    for(i in numbers)
    {
        x+=i
    }
    print("sum is $x")
}