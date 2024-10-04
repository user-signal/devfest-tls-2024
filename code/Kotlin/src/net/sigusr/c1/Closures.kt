package net.sigusr.c1

fun longComputation(x: Int): Int {
    return x * x
}

fun parametricPredicate(x: Int): (Int) -> Boolean {
    val c = longComputation(x)
    return { y -> c % y == 0 }
}

fun main() {
    val c = 42
    val predicate: (Int) -> Boolean = parametricPredicate(3)
    if (predicate(3)) println("Ok") else println("Ko")
}
