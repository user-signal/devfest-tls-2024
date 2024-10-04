package net.sigusr.c0


fun main() {
    val aList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(aList.filter { it % 2 == 0 })
}