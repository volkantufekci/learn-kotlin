package com.udemy.learnkotlin4

fun main(){
    val myInt: Int = 10
    val myLong = 10 //my long is Int


    // KOTLIN DOESNT WIDEN INTEGERS AUTOMATICALLY
    // int myInt = 10
    // Long myLong = myInt -> perfectly fine
    val someLongNumber: Long = myInt.toLong()
    // .toLong() .toInt() .toDouble() .toByte() methods are available in Int,Long,Byte,Short
    val myDouble = 13.45
    println(myDouble is Double)

    val myFloat = 12F
    println(myFloat is Float)

    val myChar = 'b'
    val myString = "b"

    // in Java, if you Char myChar = 65 that's ok
    val myOtherChar: Char = 55.toChar()
    val myBoolean = true

    // Kotlin has Boolean and Int classes defined, but they are converted to Java's int and boolean classes

    // FIXME: There was a brief intro to void, Unit, Nothing, Any

}