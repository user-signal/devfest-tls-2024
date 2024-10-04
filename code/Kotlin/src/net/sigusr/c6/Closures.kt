package net.sigusr.c6

fun longComputation(x: Int): Int {
    return x * x
}

fun parametricPredicateLambda(c: Int, yy: Int): Boolean = c % yy == 0

fun parametricPredicate(x: Int): Function1<Int, Boolean> {
    val c = longComputation(x)
    return object : Function1<Int, Boolean> {
        override fun invoke(y: Int) = parametricPredicateLambda(c, y)
    }
}

fun main() {
    val c = 42
    val predicate: Function1<Int, Boolean> = parametricPredicate(3)
    if (predicate.invoke(81)) println("Ok") else println("Ko")
}
