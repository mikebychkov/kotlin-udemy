package com.example.kotlin.loop_if_try

fun main() {

    val intStr = "ABC".."XYZ"

    val intInt = 1..100

    for (str in intInt step 5) {
        println(str)
    }

    for (str in intInt.reversed()) {
        println(str)
    }

    val rangeDown = 10.downTo(1).step(2)
    for (i in rangeDown) {
        println(i)
    }

    for (i in 20 downTo 15) {
        println(i)
    }

    for (i in 1 until 13) {
        println(i)
    }

    for (i in "Hello") {
        println(i)
    }

    val seasons = arrayOf("winter", "spring", "summer", "fall")
    seasons.forEach { println(it) }
    seasons.forEachIndexed { index, s -> println("$s season index is $index") }
    println("spring" in seasons)
    println("monday" !in seasons)


}