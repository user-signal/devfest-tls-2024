package net.sigusr.baseFunction1Simplified

fun main() {

    val aList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val sieve: (Int) -> Boolean = parametricSieve(3)
    println(aList.filter(sieve))
}

fun parametricSieve(x: Int): (Int) -> Boolean {
    val c = longComputation(x)
    return object : Function1<Int, Boolean> {
        override fun invoke(y: Int) = c % y == 0
    }
}

fun longComputation(x: Int): Int {
    return x * x
}
