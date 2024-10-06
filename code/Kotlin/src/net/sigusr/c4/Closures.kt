package net.sigusr.c4

fun longComputation(x: Int): Int {
    return x * x
}

val parametricPredicateCurried: (Int) -> (Int) -> Boolean = { x ->
    val c = longComputation(x);
    { y -> y % c == 0 }
}

fun main() {
    val c = 42
    val predicate: (Int) -> Boolean = parametricPredicateCurried(3)
    if (predicate(81)) println("Ok") else println("Ko")
}
