package com.example.basics
fun main(){
    val stringList: List<String> = listOf(
    "Denis","Frank","Shivani")
    val mixedList: List<Any> = listOf(
        "Vaithee",20.34,'I',12
    )
    for(value in mixedList){
        when(value)
        {
            is Int -> println("$value is Integer")
            is Double -> println("$value is Double")
            is String -> println("$value is String of lenght ${value.length}")
            is Char -> println("$value is a char")
            else -> println("No idea")
        }
    }
    val obj1: Any ="No idea what I'm doing"
    if(obj1 !is String){
        println("Not a String")
    }else{
        println("Found a String of length ${obj1.length}")
    }
    val obj2: Any=1337
    val str2: String?=obj2 as? String
    println(str2)
}
