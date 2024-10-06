package net.sigusr.c6

fun longComputation(x: Int): Int {
    return x * x
}

fun parametricPredicateLambda(c: Int, yy: Int): Boolean = yy % c == 0

data class Closure<C, I, O>(val capture:C, val lambda: (C, I) -> O)

fun parametricPredicate(x: Int): Closure<Int, Int, Boolean> {
    val c = longComputation(x)
    return Closure(c, ::parametricPredicateLambda)
}

fun main() {
    val c = 42
    val predicate: Closure<Int, Int, Boolean> = parametricPredicate(3)
    if (predicate.lambda(predicate.capture, 81)) println("Ok") else println("Ko")
}
