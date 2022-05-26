package com.example.kotlin.collections_generics_lambda

import java.util.StringJoiner

fun main() {

    println(countTo100_1())
    println(countTo100_2())

    val emps = listOf(
        Employee("Peter", "Davidson", 2015),
        Employee("Antony", "Hopkins", 1973),
        Employee("Nataly", "Portman", 1996),
        Employee("Christian", "Bail", 2005)
    )

    emps.minByOrNull{ it.startYear }.let{ println(it) }
    emps.minByOrNull(Employee::startYear).let{ println(it) }

    //emps.filter{ e -> e.lastName == "Portman" }.getOrNull(0)?.let{ println(it) } ?: println("Not found Portman")
    emps.filter{ it.lastName == "Portman" }.getOrNull(0)?.let{ println(it) } ?: println("Not found Portman")
    //emps.filter{ e -> e.lastName == "Winslet" }.getOrNull(0)?.let{ println(it) } ?: println("Not found Winslet")
    emps.filter{ it.lastName == "Winslet" }.getOrNull(0)?.let{ println(it) } ?: println("Not found Winslet")

    "Some String".apply some@ {
        "Another String".apply {
            println(lowercase())
            println(this@some.uppercase())
        }
    }
}

data class Employee(val firstName: String, val lastName: String, val startYear: Int)

fun countTo100_1(): String {

    return with(StringJoiner(",")) {
        for (i in 1..100) add(i.toString())
        toString()
    }
}

fun countTo100_2(): String {

    return StringJoiner(",").apply {
        for (i in 1..100) add(i.toString())
    }.toString()
}