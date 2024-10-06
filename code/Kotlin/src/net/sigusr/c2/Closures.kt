package net.sigusr.c2

fun longComputation(x: Int): Int {
    return x * x
}

fun parametricPredicate(x: Int): (Int) -> Boolean {
    val c = longComputation(x)
    return { y -> y % c == 0 }
}

fun main() {
    val aList = 1..100
    val predicate = parametricPredicate(3)
    println(aList.filter(predicate))
}
