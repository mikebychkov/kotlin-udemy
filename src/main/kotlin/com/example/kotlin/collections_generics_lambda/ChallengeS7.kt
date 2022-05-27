package com.example.kotlin.collections_generics_lambda

fun main() {

    // 1

    val joe = Person("Joe", "Jones", 45)
    val (fn, ln, age) = joe
    println("Name: $fn $ln, $age years old")

    // 2

    val jane = Person("Jane", "Air", 21)
    val mike = Person("Mike", "Tyson", 56)
    val will = Person("Will", "Smith", 48)

    val personMap = mapOf(joe.getPair(), jane.getPair(), mike.getPair(), will.getPair())
    println(personMap)

    val jNamesCount = personMap.count { it.value.firstName[0] == 'J' }
    val jNames = personMap.filter { it.value.firstName[0] == 'J' }
    println("Count of person who's name starts with J is $jNamesCount")
    println("Here they are: $jNames")

    // 3

    println(
        personMap.map { Pair(it.value.firstName, it.value.lastName) }
    )

    // 4

    personMap.forEach {
        it.value.also { println("${it.firstName} is ${it.age} years old") }
    }

    // 5

    val int1 = listOf(1,2,3,4,5)
    val int2 = listOf(4,5,6,7,8,9)

    println(
        int1 intersect int2
    )

    println(
        int1.minus(int2.minus(int1) + int1.minus(int2))
    )

    println(
        int1.filter { it in int2 }
    )

    // 6

    val regularPaper = Box<Regular>()
    var paper = Box<Paper>()
    paper = regularPaper

}

class Person(val firstName: String, val lastName: String, val age: Int) {

    operator fun component1() = firstName
    operator fun component2() = lastName
    operator fun component3() = age

    fun id(): String {
        return "$lastName$age".uppercase()
    }

    fun getPair(): Pair<String, Person> {
        return Pair(id(), this)
    }

    override fun toString() = "Name: $firstName $lastName, $age years old"
}

class Box<out T> {

}

open class Paper {

}

class Regular: Paper() {

}

class Premium: Paper() {

}
