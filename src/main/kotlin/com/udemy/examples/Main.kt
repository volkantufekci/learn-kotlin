package com.udemy.examples

fun main(){
    // without class
    //buyCar() //Should print "Bought a car"
    //sellCar() // Should print "Sold a car"
   // buyCar("Toyota") // Should print Bought Toyota -> Use string template
   // sellCar() // Sold a car
   // sellCar("Toyota")
   // sellCar("")
    // optionally take input and if input given, should print sold Toyota
//    buyCar("Toyota") // Put it into cars String arraylist and if left empty, should choose a random brand from brands array
//    sellCar() //should not compile -> sellCar("BMW") // Now that we have cars string array, optional brand must be required

// Use class now
    val dealer = Dealer() //diye bir obje yaratabilelim,
    dealer.buy(Car("Toyota"))
    dealer.buy(Car("Honda"))
    dealer.buy(Car("Toyota"))// içinde cars string arrayi olsun, arabaları ona ekleyelim

    dealer.sell("Toyota") // Remove given string from cars string array. Remove one Toyota if there are multiple, do nothing if there is no Toyota, we can change this later


// Now using, let's log who bought and sold the car, print the buyer/seller
    dealer.buy(Car("Toyota"), "Ilker")
    dealer.sell("Toyota", "Selin")

    println("---------------------")
// Change sell to error throwing method
    //dealer.sell("Bugatti", "Volkan")

// Add make buy and sell able to call with no name, in that case use TAE. Use elvis operator
    dealer.buy(Car("Volvo"))

// Use an extension function on Cars, make it random, we don't even have to use it
    val car = Car()
    car.openTheWindow()
    Car.openTheDoor()



// Write an extension function for Class, not object

// Add dealer.give method that removes a car from array and returns it, if no car exists, return null
    val oneOfDealersCars = dealer.give(dealer.boughtCars[2])

//  track the given car with String and if give() is called once, we can not call it again till the car returns (returnCar is assignment of next person) //   val anotherOneOfDealersCars = dealer.give(dealer.boughtCars[0])

// Add a return car method that takes a car and puts it into array back again and clears the tracking, now we can call give again
    dealer.takeBack(oneOfDealersCars!!)
/*
// Now check the given car and if it is some other car, it should throw error
    val someCar = dealer.give()
    dealer.takeBack(Car("Honda")) //Should throw error


// Be able to call
    val carObject = Araba()

//Now make the switch from String array to Car array
    val car = Car()
    dealer.buy(car, "Volkan")
    dealer.sell(car, "Ufuk")
    dealer.sellAll("Toyota", "Ilker")


// Now add car prices and track money
    val dealer1 = Dealer(1000) // Starts with 1000 money
    val dealer2 = Dealer() // Starts with default amount of money

    // Constructor overloading, lets say we have a class: Fonun ingilizcesi neyse
    class Fon(){
        fun kazan() = Math.random() * 1000
    }
    val dealer3 = Dealer(Fon()) // diyelim ki dealer belli bir fon ile başlıyor ama parası belli değil

*/

}

fun Car.openTheWindow() {
    println("Open the window")
}

fun Car.Companion.openTheDoor() {
    println("Open the door")
}

