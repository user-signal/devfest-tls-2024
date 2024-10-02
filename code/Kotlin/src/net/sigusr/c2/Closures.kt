package net.sigusr.c2

import net.sigusr.vrac.longComputation

fun longComputation(x: Int): Int {
    return x * x
}

val parametricSieveCurried: (Int) -> (Int) -> Boolean = { x ->
    val c = longComputation(x);
    { y -> c % y == 0 }
}

fun main() {

    val sieve: (Int) -> Boolean = parametricSieveCurried(3)

    if (sieve(3)) println("Ok") else println("Ko")
}
