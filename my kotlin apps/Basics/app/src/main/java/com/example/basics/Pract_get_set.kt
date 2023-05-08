package com.example.basics

fun main(){
    var myCar = Car()
    myCar.owner
    println("${myCar.myBrand}")
}
class Car(){
    lateinit var owner:String
    val myBrand: String ="BMW"
    get(){
        return field.toLowerCase()
    }
    init{
        this.owner ="Frank"
    }
}