package com.udemy.learnkotlin5


fun main() {
    val emp = Employee("Emp1")
    // We can not reach emp.fullTime since it is private property

    val ex = PropertiesAndBackingFields()
    println(ex.setterVisibility)
    // will give compile error
   // ex.setterVisibility = "deneme"

    // We called public get provided by default
    println("********* Default getter **********")
    val person = Person("Person1", 10)
    person.age = 11
    println(person.age)

    // We can write custom getter
    println("********* Custom getter **********")
    val animal = Animal("Dog", "Worf")
    println(animal.talks)

    // We can write custom setter
    println("********* Custom getter and setter **********")
    val animal2 = Animal("Cat", "meow")
    println(animal2.talks) // call get
    animal2.talks = "Hello Cat!" // call set
    println(animal2.talks)

    // lateinit property
    println("********* Late Init **********")
    val lateinit = LateInit()
    // Run time error
    //println(lateinit.isEmpty)
    lateinit.isEmpty = "Hello late init!"
    println(lateinit.isEmpty)
}

// kotlin class variables can only be properties, they dont have fields
// when we declare a property, kotlin creates default accessors - getters & setters
// for the fullTime property getter and setter will be private visibility
class Employee(val name: String, private val fullTime: Boolean = true) {

}

// getters and setters will have same visibility as the property or a less permissive visibility
class Person(val name:String, var age: Int) {

}

// with valid less visibility
class PropertiesAndBackingFields {
      var setterVisibility: String = "asd"
          private set // the setter is private and has the default implementation
}

// this will give compile error - Setter visibility must be the same or less permissive than property visibility
/*class PropertiesAndBackingFields {
    private var setterVisibility: String = "asd"
        public set // the setter is private and has the default implementation
}*/

// when auto generated accessors wont serve our needs, we can write our own
// if we want to write our own accessors, we need to declare them in the class, not in the primary constructor


// Each time we reach or set talks property its get and set function is called which enables us to use computed property
class Animal(val kind: String, talks: String) {
    var talks = talks
        get() {
            println("Custom getter is called from Animal instance")
            return field  // field - backing field is generated only we need to write custom getter/setter and use the property value
        }
        set(value) {
            println("Custom setter is called")
            field = value // we can set property's value using field identifier.
        }
}

// If we try to assign property like this we will get run time error
/*
class Animal2(val kind: String, talks: String) {
    var talks = talks
        get() {
            println("Custom getter is called from Animal instance")
            return talks  // field - backing field is generated only we need to write custom getter/setter and use the property value
        }
        set(value) {
            println("Custom setter is called")
            field = talks // we can set property's value using field identifier.
        }
}
*/

// val properties do not allow a setter
// This will give compile error saying - A 'val'-property cannot have a setter
/*class Udemy {
    val allByDefault = "Default property"
     set(value) {}
}*/


// lateinit
class LateInit {
    lateinit var isEmpty: String
}








