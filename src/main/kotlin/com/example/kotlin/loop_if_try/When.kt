package com.example.kotlin.loop_if_try

fun main() {

    val num = 155

    when(num) {
        in 100..200 -> println("Value is 100..200")
        300 -> println("Value is 300")
        400 -> println("Value is 400")
        else -> println("Didn't match anything")
    }

    val x = when(num) {
        in 100..200 -> {
            println("Multiplier is 5")
            num * 5
        }
        300 -> {
            println("Multiplier is 3")
            num * 3
        }
        400 -> {
            println("Multiplier is 2")
            num * 2
        }
        else -> {
            println("Has no multiplier")
            num
        }
    }
    println(x)
}