package net.sigusr.c1

fun longComputation(x: Int): Int {
    return x * x // 🤡
}

fun parametricPredicate(x: Int, y: Int): Boolean {
    val c = longComputation(x)
    return y % c == 0
}

fun main() {
    val aList = 1..100
    val filteredList = aList.filter { y -> parametricPredicate(3, y) }
    println(filteredList)

    /* [9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 99] */
}
