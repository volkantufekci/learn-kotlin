package com.udemy.learnkotlin5

fun main() {
    val str = "all of this string is lower case"
    println(str.upperFirstAndLast()) // str is the receiver object for the extension function
}


// an extension function is a member function of a class that is defined outside the class.
// Let's say we want to extend String classes functionality by adding an extension function to it
// This function acts like as if it is a function of a String class
// We will see this function for any string that we create
// IDE will show this function as hint to us when we search functions of String class
fun String.upperFirstAndLast() : String {  // String is the receiver type
    val upperFirst = this.substring(0,1 ).toUpperCase() + this.substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) + upperFirst.substring(upperFirst.length -1, upperFirst.length).toUpperCase()
}