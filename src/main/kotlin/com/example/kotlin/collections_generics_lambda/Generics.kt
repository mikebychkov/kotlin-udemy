package com.example.kotlin.collections_generics_lambda

import java.math.BigDecimal

fun main() {

    val strings = listOf("hello", "println", "goodbye")
    val ints = listOf(1, 2, 3, 55, 78)

    printList(strings)
    printList(ints)

    strings.printMe()

    val floats: List<Float> = listOf(17.3f, 67.55f, 13.1f, 88.7f, 45.9f)

    printAsInt(floats)

    append(StringBuilder("Hello"), StringBuilder("Goodbye"))

    val intsNullable: List<Int?> = listOf(1, 2, 3, 55, 78)

    printNonNullableList(ints)
    //printNonNullableList(intsNullable) // Error, non nullable values only

    val listOfValues = listOf(1, "Hello", BigDecimal(23.55), 55, 33.4f, 5678L)
    println(getElementsOfType<Long>(listOfValues))

}

fun <T> printList(list: List<T>) {
    list.forEach { println(it) }
}

fun <T> List<T>.printMe() {
    this.forEach { println(it) }
}

fun <T: Number> printAsInt(list: List<T>) {
    list.forEach { println(it.toInt()) }
}

fun <T> append(val1: T, val2: T) where T: CharSequence, T: Appendable {
    println("Appended value: ${val1.append(val2)}")
}

fun <T: Any> printNonNullableList(list: List<T>) {
    list.forEach { println(it) }
}

// REIFIED GENERIC TYPES ==========================================================================

/*
//
// CAN'T DO THIS WAY BECAUSE OF JVM TYPE ERASURE
// INSTEAD CAN USE KOTLIN INLINE FUNCTION WITH REIFIED GENERIC TYPE
//
fun <T> getElementsOfType(list: List<Any>): List<T> {
    val rsl: MutableList<T> = mutableListOf()
    list.forEach {
        if (it is T) {
            rsl.add(it)
        }
    }
    return rsl
}
*/

inline fun <reified T> getElementsOfType(list: List<Any>): List<T> {
    val rsl: MutableList<T> = mutableListOf()
    list.forEach {
        if (it is T) {
            rsl.add(it)
        }
    }
    return rsl
}
