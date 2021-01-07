package com.udemy.learnkotlin5


// We can get bytecode Tools->Kotlin->Show Kotlin Bytecode then decompile

// Non inline function - for the lambda expression compiler will be created an instance of the Function
fun higherfunc( str : String, mycall :(String)-> Unit) {
    //inovokes the print() by passing the string str
    mycall(str)
}

// the keyword println in the lambda expression is copied in the main function in the from of System.out.println
// and no further call will be required
/*inline fun higherfunc( str : String, mycall :(String)-> Unit) {
    //inovokes the print() by passing the string str
    mycall(str)
}*/


fun main(args: Array<String>) {
    print("From the main function ")
    higherfunc("To the print function",::print)
}
