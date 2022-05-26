package com.example.kotlin.collections_generics_lambda

fun main() {

    lists()
    maps()
    sets()
}

fun sets() {

    println("${"=".repeat(10)} SETS")

    val immutableSet = setOf(1,2,2,3,4,5,5)
    println(immutableSet.javaClass)
    println(immutableSet)
//    immutableSet.add(22) // immutable
    println(immutableSet.plus(33).minus(5))

    println(immutableSet.average())
    println(immutableSet.drop(3))

    //

    val mutableSet = mutableSetOf(1,2,2,3,4,5,5)
    println(mutableSet.javaClass)
    println(mutableSet)
    mutableSet.add(22)
    println(mutableSet)
    println(mutableSet.plus(33).minus(5))

    //

}

fun maps() {

    println("${"=".repeat(10)} MAPS")

    val immutableMap = mapOf(
        1 to Car("Toyota", "green", 2015),
        2 to Car("Honda", "silver", 2012),
        3 to Car("Ford", "red", 2017),
    )
    println(immutableMap.javaClass)
    println(immutableMap)

    //

    val mutableMap = mutableMapOf(
        "John's car" to Car("Toyota", "green", 2015),
        "Philipp" to Car("Honda", "silver", 2012),
        "My" to Car("Ford", "red", 2017),
    )
    println(mutableMap.javaClass)
    println(mutableMap)

    //

    val mutableMap2 = hashMapOf(
        1 to "One",
        2 to "Two",
        3 to "Three",
    )
    println(mutableMap2.javaClass)
    println(mutableMap2)

    //

    val pair = Pair(10, "Ten")
    val (first, second) = pair
    println("$first -> $second")

    for (entry in immutableMap) {
        println("${entry.key} -> ${entry.value}")
    }

    for ((k, v) in mutableMap) {
        println("$k -> $v")
    }

    val (model, color, year) = Car("Ford", "red", 2017)
    println("$model $color $year")
}

data class Car(val model: String, val color: String, val year: Int) {

    /*
    // Implemented by the "data" keyword
    operator fun component1() = model
    operator fun component2() = color
    operator fun component3() = year
    */
}

fun lists() {

    println("${"=".repeat(10)} LISTS")

    val names = listOf("Mike", "Nike", "Spike", "Duke")
    //names[0] = "Luke"
    println(names.javaClass) // immutable

    //

    val list = emptyList<String>()
    //list[0] = ""
    println(list.javaClass) // immutable

    val listItem = list.stream().findAny() // Optional
    println(listItem.orElse("NOTHING, IT'S EMPTY"))

    //

    val names2 = mutableListOf("Mike", "Nike", "Spike", "Duke")
    names2[0] = "Luke"
    names2.add("Kate")
    println(names2.javaClass) // mutable

    //

    val notNullList = listOfNotNull("hello", null, "goodbye")
    //notNullList[0] = "123"
    //notNullList.add("")
    println(notNullList)
    println(notNullList.javaClass) // immutable

    //

    val arrayList = arrayListOf(1, 2, 3)
    arrayList[0] = 45
    arrayList.add(33)
    println(arrayList.javaClass) // mutable

    //

    val array = arrayOf("black", "white", "gray")
    println(array.javaClass)
    println(array.toList().javaClass) // immutable
    println(listOf(*array).javaClass)

    val nextArrayList = array.toList()
//    nextArrayList[0] = "blue"
//    nextArrayList.add("green")

    //

    val anotherArray = intArrayOf(1, 2, 3)
    anotherArray[0] = 5
    println(anotherArray.javaClass) // primitive mutable array

    //

    var names3 = listOf(*names.toTypedArray(), *names2.toTypedArray())
    println(names3)

    var names4 = names + names2
    println(names4.distinct())

    var names5 = names.union(names2) // DISTINCT
    println(names5)

    //

    val coolNames = names5.asSequence().filter{ it == "Mike" }.map(String::uppercase).toList() // Kotlin analog of Java StreamApi
    println(coolNames)
}