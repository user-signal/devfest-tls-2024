package net.sigusr.c4

fun longComputation(x: Int): Int {
    return x * x
}

fun parametricSieve_lambda(c: Int, yy: Int): Boolean = c % yy == 0

data class Closure<C, I, O>(val capture:C, val lambda: (C, I) -> O)

fun parametricSieve(x: Int): Closure<Int, Int, Boolean> {
    val c = longComputation(x)
    return Closure(c, ::parametricSieve_lambda)
}

fun main() {

    val sieve: Closure<Int, Int, Boolean> = parametricSieve(3)

    if (sieve.lambda(sieve.capture, 3)) println("Ok") else println("Ko")
}
