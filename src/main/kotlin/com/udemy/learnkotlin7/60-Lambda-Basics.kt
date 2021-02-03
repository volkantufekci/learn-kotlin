package com.udemy.learnkotlin7

import java.lang.Exception

fun main(){
   /* arrayOf(1,2,3).forEach {
        println(it)
    }


    // Notice there is no () after forEach. That's because Kotlin compiler accepts
    // the last parameter, out of the parantheses if it is lambda. Some lambdas -> forEach, ?.let ?.apply



    // Type run and see the auto suggest. Read the signature there
    val result = myRun {
        println("Hello")
    }

    // 1- Write your own "run" method and show how the signature syntax is written for a lambda with no input


    // 2 - Talk a little about how callback is just a function block but it is cold, meaning it doesn't run if you call it
    // Show the example below:
    var x = 10
    val callback = {
        x = 25
    }
    println(x)
    callback() // also we can use run(callback)
    println(x)
*/
    // Also show that we can pass existing functions as lambdas like SomeOtherClass::functionX. this can be omitted run(::funcY)  is same as run(this::funcY)
    // 2- Write your own forEach method for integers (don't go into generics)
    /*arrayOf(10,20,30).myForEach {
        println(it)
    }*/

    // 3- Show the word "it" in forEach. And talk a little about type inference here
    // 4 - Write your own lambda with two inputs. Which is below:
                                            //1 2 3      1
    arrayOf(1,2,3).myForEachWithTwoParams ("**************") { param1, param2 ->
        println(param1 + param2)
    }



    // 5 - Write your own lambda function that takes two lambdas. Write the method for:
     safeRun ( {
         3 / 0
     },
            onError = {
                println("**** ERROR OCCURED:")
                println(it)
            },
            onSuccess = { result ->
                println("SUCCESSFUL RESULT: ")
                println(result)
            })


    // 6 - Write a method that takes nullable action as parameter
    /*
    doX()
    doX { errorMessage ->
        println(errorMessage)
    }
    */



    myRun()

}



fun myRun(functionToRun: (   () -> Unit   )? = null ){
    if(functionToRun!=null)
        functionToRun()
}



class Animal{
    val age: Int = 3
    fun walk() {
        println("WALKING")
    }

}


fun Array<Int>.myForEach(whatToRun: (Int) -> Unit ){
    for(item in this){
        whatToRun(item)
    }
}

fun Array<Int>.myForEachWithTwoParams(separator: String, whatToRun: (Int, Int) -> Unit ){
    for(item in this){
        whatToRun(item, 1)
        println(separator)
    }
}


fun safeRun( whatToRun: () -> Int, onSuccess: (Int) -> Unit, onError: (Exception) -> Unit  ){
    var result: Int = -1
    try {
        result = whatToRun()
        onSuccess(result)
    }
    catch(exception: Exception){
        onError(exception)
    }
}