package com.udemy.learnkotlin5


// Default return type is Unit - we do not need to explicitly specify it
fun main(args: Array<String>): Unit {
    println(labelMultiply(3,4, "The result is:"))
    println(simplifiedLabelMultiply(3,4, "The result is:"))
    println(simplifiedLabelMultiply2(3,4, "The result is:"))

    val emp = Functions("jane")
    println(emp.upperCaseFirstName())

    println(defaultParamater(3,4))

    // We can mix parameter order of a function using parameter names - named parameters
    println(labelMultiply(label = "This is my label", operand2 = 5, operand1 = 2))

    var car1 = FunctionsCar("blue", "toyota", 2016)
    var car2 = FunctionsCar("red", "toyota", 2015)
    var car3 = FunctionsCar("green", "toyota", 2016)

    printColors(car1, car2, car3)

    val arrayList = arrayOf(1, 2, 3, 4)
    val result = getAverage(arrayList)
    println(result)

    val result1 = getAverage2(1, 2, 3)
    val result2 = getAverage2(1, 2, 3, 4, 5)
    println(result1)
    println(result2)


    // arrayOf() also uses vararg
    val arr = arrayOf(1,2,3)

    val manyCars = arrayOf(car1,car2, car3)
    // Spread operator, to unpack an array
    printColors(*manyCars)

    val moreCars = arrayOf(car2, car3)
    val car4 = car2.copy()
    // To unpack an array and to use individual elements use spread operator!
    val lotsOfCars = arrayOf(*manyCars, *moreCars, car4)

    for (c in lotsOfCars) {
        println(c)
    }

    printColorsWithMoreArgs(car1, car2, car3, str = "String")
    // Will not compile
    // printColorsWithMoreArgs(car1, car2, car3, "String")

    printColorsWithVarargsAtTheEnd("String", car1, car2, car3)
}


// we only have 1 expression in the function body we can simplify it
// function with a block body
fun labelMultiply(operand1: Int, operand2: Int, label: String) : String {
    return ("$label ${operand1*operand2}")
}

// Remove return and curly braces and assign result directly
fun simplifiedLabelMultiply(operand1: Int, operand2: Int, label: String) : String = "$label ${operand1*operand2}"

// Compiler can infer return type
// function with an expression body
fun simplifiedLabelMultiply2(operand1: Int, operand2: Int, label: String) = "$label ${operand1*operand2}"


// Will get compile error
// fun whatever () : Unit = 3 * 4

// This will also work because println() returns nothing and main also returns nothing (Unit)
/*fun main(args: Array<String>) =
    println(labelMultiply(3,4, "The result is:"))*/



// when a function is a member of a class it is usually referred as method or as a member function
class Functions(val firstName: String) {
    fun upperCaseFirstName() = firstName.toUpperCase()
}

// We can use default value for a func parameter
fun defaultParamater(operand1: Int, operand2: Int, label: String = "The answer is: ") = "$label ${operand1*operand2}"

// We have to include type of the parameters of functions
// This will not compile
// fun defaultParamater(operand1: Int, operand2: Int, label = "The answer is: ") = "$label ${operand1*operand2}"


fun getAverage(numbersList: Array<Int>): Float {

    var sum = 0.0f
    for (item in numbersList) {
        sum += item
    }
    return (sum / numbersList.size)
}

fun getAverage2(vararg input: Int): Float {
    var sum = 0.0f
    for (item in input) {
        sum += item
    }
    return (sum / input.size)
}

data class FunctionsCar(val color: String, val model: String, val year: Int)


// We can only have 1 vararg parameter
fun printColors(vararg cars: FunctionsCar) {
    for (car in cars) {
        println(car.color)
    }
}

// If we have varargs at the beginning of the function we need to call the function using named parameter
// Because if we have String type for varargs, compile will get confused
fun printColorsWithMoreArgs(vararg cars: FunctionsCar, str: String) {
    for (car in cars) {
        println(car.color)
    }
}

// We can call this function without named parameter
fun printColorsWithVarargsAtTheEnd(str: String, vararg cars: FunctionsCar) {
    for (car in cars) {
        println(car.color)
    }
}

