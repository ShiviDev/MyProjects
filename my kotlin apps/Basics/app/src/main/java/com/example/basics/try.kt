package com.example.basics

fun main(){
    val obj: Any?=null
    val obj1: String? = obj as? String
    println(obj1)
}