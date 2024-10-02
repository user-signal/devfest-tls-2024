package net.sigusr.c3

fun longComputation(x: Int): Int {
    return x * x
}

fun parametricSieve_lambda(c: Int, yy: Int): Boolean = c % yy == 0

fun parametricSieve(x: Int): (Int) -> Boolean {
    val c = longComputation(x)
    return { y -> parametricSieve_lambda(c, y) }
}

fun main() {

    val sieve: (Int) -> Boolean = parametricSieve(3)

    if (sieve(3)) println("Ok") else println("Ko")
}
