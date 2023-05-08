package com.example.basics

fun main(){
    val iphone = MobilePhone("iOs","Apple","iPhone 12")
}
class MobilePhone(osName: String, brand: String, model:String)
{
    init{
        println("The phone $model from $brand uses $osName as it's Operating System")
    }
}