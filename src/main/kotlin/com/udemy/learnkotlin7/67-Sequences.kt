package com.udemy.learnkotlin7

import kotlin.system.measureTimeMillis




val availableBrands = arrayOf("Mercedes", "BMW", "Audi")
const val totalCars = 500000000
fun main(){
/*    val hugeList = arrayListOf<Car>()
    val createDuration = measureTimeMillis {
        for(i in 1..totalCars) {
            hugeList.add(getCarFromDBWithId(i))
        }
    }

    // We
    var newList: List<Car>? = null
    val modifyDuration = measureTimeMillis {
        newList = hugeList
                .map(saveItsRecordToGovernment)
                .filter(takeAudis)
                .map(increaseTaxAndSaveCar)
    }*/
    val regularTime = measureTimeMillis {
        val reTaxedCars = (1..totalCars)
                .map { Car(it.toLong(), availableBrands[it%3],"Car with Id: $it", tax=100 ) }
                .map(saveItsRecordToGovernment)
                .filter(takeAudis)
                .map(increaseTaxAndSaveCar)
                .toList()
    }

    // INSTEAD USE SEQUENCES
    val sequenceTime = measureTimeMillis {
        val reTaxedCars = (1..totalCars)
                .asSequence()
                .map { Car(it.toLong(), availableBrands[it%3],"Car with Id: $it", tax=100 ) }
                .map(saveItsRecordToGovernment)
                .filter(takeAudis)
                .map(increaseTaxAndSaveCar)
                .toList()
    }



    println()
    /*println("Imported ${hugeList.size} cars in: " + createDuration + " msec")
    println("Recalculated taxes of ${newList?.size} cars in: " + modifyDuration + " msec")
    println("Total Duration: ${createDuration + modifyDuration}")
    */
    println("Regular Duration: $regularTime")
    println("Sequence Duration: $sequenceTime")


    // IMPORTANT NOTE: Collections are very efficient, we don't need to convert small lists to sequences

}

fun getCarFromDBWithId(i: Int) = Car(i.toLong(), availableBrands[i % 3], "Car with Id: $i", tax = 100)


val saveItsRecordToGovernment: (Car) -> Car = {
    print(" ")
    it
}
val takeAudis: (Car) -> Boolean = {
    it.brand == "Audi"
}
val increaseTaxAndSaveCar: (Car) -> Car = {
    it.tax += 50
    it
}



data class Car(val id: Long, val brand: String, val name: String, var tax: Int)


/*
// FOR 5 Million
Regular Duration: 7461
Sequence Duration: 7334
*/



/*
// FOR 50 Million
Regular Duration: 96253
Sequence Duration: 78096
*/


