package com.senix22.oophomework

data class Person(var name: String, var age: Int, var mom: Person?, var dad: Person?, var bas: List<Person>?) {

    fun count1(): Int? {
        var count = 0
        mom?.mom?.let { count++ }
        mom?.dad?.let { count++ }
        mom?.bas?.let { count += mom?.bas?.size?: 0 }
        dad?.mom?.let { count++ }
        dad?.dad?.let { count++ }
        dad?.bas?.let { count += mom?.bas?.size?: 0 }
        dad.let { count++ }
        mom.let { count++ }
        bas.let { count += bas?.size?: 0 }

        return count
    }


}

fun getMe(): Person {

    val momsGrandMother = Person("Olha", 63, null, null, null)
    val momsGrandFather = Person("Stanislav", 64, null, null, null)
    val momBroths = listOf<Person>(Person("Leonid", 42, momsGrandMother, momsGrandFather, null),
        Person("Brother2", 44, momsGrandMother, momsGrandFather, null))
    val mom = Person("Veronika", 44, momsGrandMother, momsGrandFather, momBroths)


    val dadsGrandMother = Person("Alla", 63, null, null, null)
    val dadsGrandFather = Person("Leonid", 63, null, null, null)
    val dadBroth = listOf<Person>(Person("Yura", 40, dadsGrandMother, dadsGrandFather, null))
    val dad = Person("Serhiy", 42, dadsGrandMother, dadsGrandFather, dadBroth)

    val brat = listOf(Person("Brat", 18, mom, dad, null), Person("Brat2", 188, mom, dad, null))
    val me = Person("Oleh", 20, mom, dad, brat)


    return me

}

fun main() {
    println(getMe())
    println(" i have ${getMe().count1()} relatives")

}