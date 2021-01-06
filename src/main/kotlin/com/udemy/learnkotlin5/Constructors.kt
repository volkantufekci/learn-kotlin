package com.udemy.learnkotlin5

fun main() {
    // Default Constructor
    println("${DefaultConstructor()}")

    // Primary Constructors
    // Assign value to the firstName property of the class
    println("${LongConstructor("Emp1").firstName}")
    println("${ShortenedVsOneConstructor("Emp2").firstName}")
    println("${ShortenedVsTwoConstructor("Emp3").firstName}")

    val constructorWithDefaultValueEmployee = ConstructorWithDefaultValue("Emp4")
    println("${constructorWithDefaultValueEmployee.firstName}  ${constructorWithDefaultValueEmployee.secondName}")

    // Private constructor
    // println("${ProtectedConstructorEmployee("Emp3").firstName}")

    // Secondary Constructor
    println("${SecondaryConstructorOnly("SecCons").firstName}")
    val secCons = SecondaryConstructorWithPrimary("SecCons", "Last Name")
    println("${secCons.firstName} ${secCons.lastName}")

    // Default last name = " " will be used
    val secConsWithOnlyFirstName = SecondaryConstructorWithPrimary("Only First Name")
    println("${secConsWithOnlyFirstName.firstName} ${secConsWithOnlyFirstName.lastName}")

    // lateinit - if we do not initialize lateinit property we will get run time error
    val secConsWithLateInit = SecondaryConstructorWithLateInıt("Only First Name", 12)
    secConsWithLateInit.lastName = "Surname"
    println("firstName: ${secConsWithLateInit.firstName} secondName: ${secConsWithLateInit.lastName} age: ${secConsWithLateInit.age}")

}


class DefaultConstructor { // Default constructor will be created
}


//Primary Constructor

// Primary constructor is part of the class header
// Primary constructor can not contain code block
// When you have only a primary constructor and you need to have init block to write code

class LongConstructor constructor(firstName: String) { // Primary constructor - defined in outside of the curly braces
    val firstName: String

    init { // init is called when an instance is created
        this.firstName = firstName
    }
}


class ShortenedVsOneConstructor constructor(firstName: String) {
    val firstName = firstName
}

// We can use var instead of val with the property also
class ShortenedVsTwoConstructor (val firstName: String) { // Declare the property and remove constructor keyword - when the constructor is public

}

class ConstructorWithDefaultValue (val firstName: String, var secondName: String = "Last Name") { // Give default values to properties

}

// We need constructor keyword if we need to use access modifiers with constructor, ex:
class ProtectedConstructorEmployee private constructor(val firstName: String) { // Declare the property and remove constructor keyword

}

// Secondary Constructors

// Secondary constructors do not declare properties for us.
/*class SecondaryConstructorOnly {
    var firstName: String
    constructor(val firstName: String) { // This will give compile error
        this.firstName = firstName
    }
}*/


// We can use secondary constructors when we need multiple types of constructor
// We can use secondary constructors when we need to put additional initialization logic
// They are created using constructor keyword

class SecondaryConstructorOnly { // do not use () here
    var firstName: String

    constructor(firstName: String) {
        this.firstName = firstName
    }
}

// We need to call - if we have one- the primary constructor from the secondary constructor

/*class SecondaryConstructorWithPrimary(val firstName: String) {
    var lastName: String = "LastName"
    constructor(firstName: String, lastName: String) { // This line will compile error - Primary constructor call expected
    }
}*/

class SecondaryConstructorWithPrimary(val firstName: String) {
    var lastName: String = ""
    constructor(firstName: String, lastName: String) : this(firstName) { // Call the primary constructor
        this.lastName = lastName
    }
}

// lateinit
class SecondaryConstructorWithLateInıt(val firstName: String) {
    lateinit var lastName: String  // it will defined later - other than construction time!
    var age: Int = 0

    constructor(firstName: String, age: Int) : this(firstName) { // Call the primary constructor
        this.age = age
    }
}


// NOTE: Prefer primary constructor since its more concise