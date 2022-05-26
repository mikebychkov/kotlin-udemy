package com.example.kotlin.oop

//

open class Fruit(val size: String)

class Apple(size: String): Fruit(size)

//

abstract class Pet(private val name: String, private val sound: String = "...") {

    open fun makeSound() = println("$name says: $sound")
    abstract fun findOutColor(): String
}

data class Dog(val name: String, val color: String): Pet(name, "Bark") {

    override fun makeSound() = super.makeSound()
    override fun findOutColor() = this.color
}

data class Turtle(val name: String, val color: String): Pet(name) {

    override fun findOutColor() = this.color
}

fun main() {

    val jack: Pet = Dog("Jack", "Black")
    jack.makeSound()

    val turtle = Turtle("Clint", "Red")
    turtle.makeSound()

    val stranger = Human()
    stranger.shout()

    val monster = Zerg()
    monster.shout()
}

//

interface Expressions {

    fun shout() {
        println("...")
    }
}

interface FootballFans: Expressions {

    fun fight()
}

class Human: FootballFans {

    override fun fight() {
        println("Fighting with opposite team fans")
    }

    override fun shout() {
        println("Gooool!!!")
    }
}

class Zerg: FootballFans {

    override fun fight() {
        println("POIOjklhk hkkjh khkj")
    }
}

//

open class Bat() {

    fun flight() = println("I'm flying at night!!!")
}

open class Detective() {

    fun fightCrime() = println("I'm fighting crime!!!")
}

class Batman(): Bat() //, Detective() // CAN'T INHERIT 2 CLASSES
{
    fun flappySound() {
        println("Flappy sounds all over around")
    }
}

//