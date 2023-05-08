package com.example.basics

fun main(){
    var x : Any =13.37F
    when(x){
        is Int -> println("$x is an Int")
        !is Double -> println("$x is a Double")
        else -> println("$x is none of the aboove")

    }
    var month = 3
    when(month){
        1,2,3-> println("Spring")
        in 4..6->println("Summer")
        in 7..9->println("Fall")
        in 10..12->println("Winter")
        else ->println("Invalid")
    }
    for(i in 1 until 10)
        print("$i ")

    var humidity = "humid"
    var humidityLevel = 80
    while(humidityLevel>=60)
    {
        humidityLevel-=5
        println("Humidity level decreased")
    }
    println("It's comfy now")
}