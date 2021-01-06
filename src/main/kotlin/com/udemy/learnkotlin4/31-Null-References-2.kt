package com.udemy.learnkotlin4

fun main(){
    /******** Not Null Assertions  !!
    1- When we are absolutely sure if something is not null
    2- When we absolutely want a Crash if something comes null (from 3rd party code for example)
    */

    val nullString: String? = null
    val notNullString: String? = "SomeString"
    val maybeNull: String? = maybeGetNull()


    println(notNullString!!)
    // The line below will thrown NullPointerException -> But not Java's NPE but Kotlin's
    // println(nullString!!)
    onlyExceptsStrings_ToPrintUppercase(notNullString) // -> Auto Smartcast
    // Below line will not be compiled, because compiler knows that this value is null
    // onlyExceptsStrings_ToPrintUppercase(nullString)

    // If there is a chance for a variable to be null, compiler wont compile. See below line
    // onlyExceptsStrings_ToPrintUppercase(maybeNull)

    /*
     nullString / notNullString / maybeNull -> All have same explicit (not inferred type)

     onlyExceptsStrings_ToPrintUppercase(notNullString) is actually the same as:

     val converted: String = notNullString as String
     onlyExceptsStrings_ToPrintUppercase(converted)
    */

    // Remember the safe-call operator, call a method if not null, else return null
    println(maybeNull?.toUpperCase())
    // If we want to run a method of some other class if it is not null for example:
    if(maybeNull != null)
        Some3rdPartyClass.onlyAcceptsString(maybeNull)

    // Kotlin's shorthand let
    maybeNull?.let {
        Some3rdPartyClass.onlyAcceptsString(it)
    }
    // Note the lambda in let

    // Check out the myLet function that is exact same with let
    maybeNull?.myLet {
        Some3rdPartyClass.onlyAcceptsString(it)
    }
    // only differece is myLet works on String? and let is generic type, means it can run on any class


}

fun onlyExceptsStrings_ToPrintUppercase(someString: String){
    println(someString.toUpperCase())
}

fun maybeGetNull(): String? {
    return if (Math.random() > 0.5) "Random is larger than half" else null
}

object Some3rdPartyClass {
    fun onlyAcceptsString(param: String){
        // NO-OP
    }
}

fun String?.myLet(theProcedureToCallIfNotNull: (String) -> Unit ){
    if(this != null )
        theProcedureToCallIfNotNull(this as String) // Smartcast greys out as String part
}