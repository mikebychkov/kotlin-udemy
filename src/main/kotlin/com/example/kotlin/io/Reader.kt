package com.example.kotlin.io

import java.io.File

fun main() {

    /*
    val reader = File("text-file").reader()
    val lines = reader.readLines()
    lines.forEach { println(it) }
    reader.close()
    */

    // "USE" CLOSES OPENED RESOURCES AS TRY WITH RESOURCES DO IN JAVA

    val lines = File("text-file").reader().use { it.readLines() }
    lines.forEach { println(it) }

    val lines2 = File("text-file2").bufferedReader().use { it.readText() }
    println(lines2)

    val lines3 = File("text-file").readText()
    println(lines3)


    // PREVIOUS METHODS NOT RECOMMENDED TO USE WITH BIG FILES
    // FOR PARTIAL FILE READ USE NEXT:

    File("text-file2").reader().forEachLine { println(it) }


    // WALK FILE TREE

    File(".").walkTopDown().forEach { println(it) }

    println("=".repeat(100))

    File(".").walkTopDown().filter { it.name.endsWith(".kt") }.forEach { println(it) }

}