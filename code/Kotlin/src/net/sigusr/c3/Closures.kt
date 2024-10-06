package net.sigusr.c3

fun longComputation(x: Int): Int {
    return x * x
}

fun parametricPredicate(x: Int): (Int) -> Boolean {
    val c = longComputation(x)
    return { y -> y % c == 0 }
}

fun main() {
    val c = 42
    val predicate: (Int) -> Boolean = parametricPredicate(3)
    if (predicate(81)) println("Ok") else println("Ko")
}
