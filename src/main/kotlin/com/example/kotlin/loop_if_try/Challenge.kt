package com.example.kotlin.loop_if_try

fun main() {

    // 1

    for (i in 5..5000 step 5) {
        println(i)
    }

    for (i in -500..0) {
        println(i)
    }

    // 2

    var prev1 = 0
    println(prev1)
    var prev2 = 1
    println(prev2)
    for (i in 3..15) {
        val recent = prev1 + prev2
        println(recent)
        prev1 = prev2
        prev2 = recent
    }

    val arr = Array(15) { 0 }
    arr[1] = 1
    for (i in 2..14) {
        arr[i] = arr[i - 1] + arr[i - 2]
    }
    arr.forEach { println(it) }

    // 3

    // 1,11,100,99,98,2

    for (i in 1..5) {
        println(i)
        if (i == 2) break
        j@ for (j in 11..20) {
            println(j)
            for (k in 100 downTo 90) {
                println(k)
                if (k == 98) break@j
            }
        }
    }

    // 4

    val num = 0
    val dnum = if (num > 100) { -234.567 } else if (num < 100) { 4444.555 } else { 0.0 }
    println(dnum)

    val num2 = 235
    val dnum2 = when {
        num2 > 100 -> -234.567
        num2 < 100 -> 4444.555
        else -> 0.0
    }
    println(dnum2)

}