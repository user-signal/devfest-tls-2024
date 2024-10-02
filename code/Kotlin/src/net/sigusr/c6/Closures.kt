package net.sigusr.c6

fun longComputation(x: Int): Int {
    return x * x
}

fun parametricSieve_lambda(c: Int, yy: Int): Boolean = c % yy == 0

fun parametricSieve(x: Int): Function1<Int, Boolean> {
    val c = longComputation(x)
    return object : Function1<Int, Boolean> {
        override fun invoke(y: Int) = parametricSieve_lambda(c, y)
    }
}

fun main() {

    val sieve: Function1<Int, Boolean> = parametricSieve(3)

    if (sieve.invoke(3)) println("Ok") else println("Ko")
}
