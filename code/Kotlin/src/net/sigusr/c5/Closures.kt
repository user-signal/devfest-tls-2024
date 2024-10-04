package net.sigusr.c5

fun longComputation(x: Int): Int {
    return x * x
}

fun parametricPredicateLambda(c: Int, yy: Int): Boolean = c % yy == 0

interface Closure<I, O> {
    fun invoke(y: I): O
}

fun parametricPredicate(x: Int): Closure<Int, Boolean> {
    val c = longComputation(x)
    return object : Closure<Int, Boolean> {
        override fun invoke(y: Int): Boolean = parametricPredicateLambda(c, y)

    }
}

fun main() {

    val predicate: Closure<Int, Boolean> = parametricPredicate(3)

    if (predicate.invoke(3)) println("Ok") else println("Ko")
}
