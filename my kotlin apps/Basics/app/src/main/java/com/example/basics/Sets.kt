package com.example.basics

fun main(){
    val fruits = setOf("Orange","Apple","Mango","Blueberry")
    println(fruits.toSortedSet())//alphabetical order
    println(fruits.size)

    val newFruits=fruits.toMutableList()
    newFruits.add("Water Melon")
    newFruits.add("Pear")
    println(newFruits)
    print(newFruits.elementAt(3))

    val daysOfTheWeek= mapOf(1 to "Monday", 2 to "Wednesday", 3 to "Tuesday")
    for(key in daysOfTheWeek.keys){
        print("\n$key is to ${daysOfTheWeek[key]}")
    }
    val addTo = daysOfTheWeek.toMutableMap()
    addTo[4]="Thursday"
    addTo[6]="Saturday"
     print(addTo.toSortedMap())
}