package net.sigusr.c1

fun longComputation(x: Int): Int {
    return x * x
}

fun parametricSieve(x: Int): (Int) -> Boolean {
    val c = longComputation(x)
    return { y -> c % y == 0 }
}

fun main() {

    val sieve: (Int) -> Boolean = parametricSieve(3)

    if (sieve(3)) println("Ok") else println("Ko")
}
