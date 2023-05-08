package com.example.basics

interface Drivable{
    val maxSpeed: Double
    fun drive():String
    fun brake(){
        println("The drivable is braking")
    }
}
open class Cars(override val maxSpeed:Double): Drivable
{
    override fun drive()="Driving"
    fun speed(){
        println("Vroom @ $maxSpeed")
    }
}

class ElectricCar(override val maxSpeed: Double):Cars(maxSpeed){

}
fun main(){
    val Tesla = ElectricCar(200.20)
    Tesla.brake()
    Tesla.speed()
}
/*
Case 2:
open class Cars(): Drivable
{
    override val maxSpeed: Double=20.0
    override fun drive()="Driving"
}

class ElectricCar():Cars(){

}
*/