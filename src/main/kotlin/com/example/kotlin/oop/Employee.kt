package com.example.kotlin.oop

data class Employee(val firstName: String, val fullTime: Boolean = true, private var salary: Long = 1000) {

    fun updateSalary(newValue: Long) {
        this.salary = newValue
    }
}

fun Int.plus(vararg params: Int): Int {
    return this + params.sum()
}

fun Int.plus2(vararg params: Int) = this + params.sum()

/*
fun Employee.hack() {
    this.salary = 1000000000000
}
 */

fun main() {

    val emp1 = Employee("Sarah", salary = 2000);
    println(emp1)

    val emp2 = Employee("Rick", false);
    //emp2.hack()
    emp2.updateSalary(3000)
    println(emp2)

    val num = 5
    println(num.plus(4, 3, 5, 7))
}