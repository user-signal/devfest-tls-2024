package net.sigusr.c5

fun longComputation(x: Int): Int {
    return x * x
}

fun parametricSieve_lambda(c: Int, yy: Int): Boolean = c % yy == 0

interface Closure<I, O> {
    fun invoke(y: I): O
}

fun parametricSieve(x: Int): Closure<Int, Boolean> {
    val c = longComputation(x)
    return object : Closure<Int, Boolean> {
        override fun invoke(y: Int): Boolean = parametricSieve_lambda(c, y)

    }
}

fun main() {

    val sieve: Closure<Int, Boolean> = parametricSieve(3)

    if (sieve.invoke(3)) println("Ok") else println("Ko")
}
