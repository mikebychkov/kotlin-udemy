package com.example.kotlin.oop.challenge

open class KBicycle(var cadence: Int, var speed: Int, var gear: Int = 10) {

    fun applyBreak(decrement: Int) { speed -= decrement }
    fun speedUp(increment: Int) { speed += increment }
    open fun printDescription() = println("""=============
        |Bike is in gear $gear 
        |with a cadence of $cadence 
        |travelling at a speed of $speed.""".trimMargin())
}

class KMountainBike(var seatHeight: Int, cadence: Int, speed: Int, gear: Int = 16): KBicycle(cadence, gear, speed) {

    companion object {
        val availableColors = listOf("blue", "red", "green", "yellow")
    }

    constructor(color: String, seatHeight: Int, cadence: Int, speed: Int, gear: Int = 16) : this(seatHeight, cadence, gear, speed) {
        println("""=============
            |The mountain bike color is $color
            |Available colors: ${availableColors.reduce {S,T -> "$S, $T"} }""".trimMargin())
    }

    override fun printDescription() {
        super.printDescription()
        println("The mountain bike has a seat height of $seatHeight inches.")
    }
}

class KRoadBike(val tireWidth: Int, cadence: Int, speed: Int, gear: Int = 5): KBicycle(cadence, gear, speed) {

    override fun printDescription() {
        super.printDescription()
        println("The road bike has a tire width of $tireWidth MM.")
    }
}

fun main() {

    /*
    val bike1 = KBicycle(5, 5)
    bike1.printDescription()

    val bike2 = KMountainBike(5, 5, 5)
    bike2.printDescription()

    val bike3 = KRoadBike(5, 5, 5)
    bike3.printDescription()
     */

    val bike2Yellow = KMountainBike("Yellow",5, 5, 5)
    bike2Yellow.printDescription()
}