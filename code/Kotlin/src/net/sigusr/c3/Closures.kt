package net.sigusr.c3

fun longComputation(x: Int): Int {
    return x * x
}

fun parametricPredicateLambda(c: Int, yy: Int): Boolean = c % yy == 0

fun parametricPredicate(x: Int): (Int) -> Boolean {
    val c = longComputation(x)
    return { y -> parametricPredicateLambda(c, y) }
}

fun main() {
    val c = 42
    val predicate: (Int) -> Boolean = parametricPredicate(3)
    if (predicate(81)) println("Ok") else println("Ko")
}