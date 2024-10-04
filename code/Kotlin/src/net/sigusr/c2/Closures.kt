package net.sigusr.c2

fun longComputation(x: Int): Int {
    return x * x
}

val parametricPredicateCurried: (Int) -> (Int) -> Boolean = { x ->
    val c = longComputation(x);
    { y -> c % y == 0 }
}

fun main() {

    val predicate: (Int) -> Boolean = parametricPredicateCurried(3)

    if (predicate(3)) println("Ok") else println("Ko")
}
