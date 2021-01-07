package com.udemy.learnkotlin5

// Top Level Items

private class PrivateClass { // We can use it in the same file when we use private
    // We can not see this class from anywhere of the project except this file
    override fun toString(): String {
        return "I am private class instance"
    }
}

private val privateString = "Top Level Item - Private String"

class PublicClass {  // all classes public and final by default
    override fun toString(): String {
        return "I am public class instance"
    }
}

val publicString = "Top Level Item - Public String"

var bar: Int = 5 // property is visible everywhere
    private set    // setter is visible only in AccessModifiers.kt


internal class InternalClass {  // internal is visible in only in a module that it is defined
    override fun toString(): String {
        return "I am internal class instance"
    }
}

internal val internalString = "Top Level Item - Internal String"


// Classes

open class Outer {
    private val a = 1 // visible for only in Outer class members & functions
    protected open val b = 2 // visible for both Outher class and its subclasses
    internal val c = 3 // visible for Outher class, its subclasses and clients declared in the same module with this class
    val d = 4  // public by default // visible for Outher class, its subclasses, and any clients

    protected class Nested { // Visible for Outer and its subclasses
        public val e: Int = 5 // Visible for Outer and its subclasses
    }
}

class Subclass : Outer() {
    // a is not visible
    // b, c and d are visible
    // Nested and e are visible

    override val b = 5   // 'b' is protected
}

class Client(o: Outer) {
    // o.a, o.b are not visible
    // o.c and o.d are visible (same module)
    // Outer.Nested is not visible, and Nested::e is not visible either
}


// Constructors
class C private constructor(val a: Int) {
    companion object {
        val a = "I am a companion object"
    }
}

fun main() {
    println("${PublicClass()}")
    println("${PrivateClass()}")
    println("${InternalClass()}")
    println("$publicString")
    println("$privateString")
    println("$internalString")

    bar = 10 // we can access bar and set it since its setter is private in this file
    println("$bar")


    println("${C.a}") // We can access companion object of a class with private constructor
}