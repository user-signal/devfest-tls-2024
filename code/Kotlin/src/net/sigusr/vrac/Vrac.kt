package net.sigusr.vrac

import kotlin.collections.filterTo

fun main() {

    val aList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println(aList.filterRec { it % 2 == 0 })

    println(filterRec(aList) { it % 2 == 0 })
    println(filterRec(aList, { it % 2 == 0 }))
    println(filterRec(aList, { someInt -> someInt % 2 == 0 }))

    val sieve: (Int) -> Boolean = parametricSieve(3)
    println(filterRec(aList, sieve))

    val sieveCurried: (Int) -> Boolean = parametricSieveCurried(3)
    println(filterRec(aList, sieveCurried))
}

fun <T> Iterable<T>.filterRec(predicate: (T) -> Boolean): List<T> {
    return filterTo(ArrayList<T>(), predicate)
}

fun <T, C : MutableCollection<in T>> Iterable<T>.filterTo(destination: C, predicate: (T) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

fun parametricSieve(x: Int): (Int) -> Boolean {
    val c = longComputation(x)
    return { y -> c % y == 0 }
}

val parametricSieveCurried: (Int) -> (Int) -> Boolean = { x ->
    val c = longComputation(x);
    { y -> c % y == 0 }
}

// fun parametricSieve(x: Int): (Int) -> Boolean {
//    val c = longComputation(x)
//    return { c % it == 0 }
// }

//val sieve: (Int) -> Boolean = parametricSieve(longComputation(3))
//fun parametricSieve(p: Int): (Int) -> Boolean {
//    return { y: Int -> p % y == 0 }
//}

fun parametricSieve(x: Int, p: Int): (Int) -> Boolean = { p % it == 0 }

fun longComputation(x: Int): Int {
    return x * x
}

fun filterRec(list: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    fun filterAux(list: List<Int>, predicate: (Int) -> Boolean, acc: List<Int>): List<Int> =
        when (list.isEmpty()) {
            true -> acc
            false -> {
                val first = list.first()
                if (predicate(first)) {
                    filterAux(list.drop(1), predicate, acc + first)
                } else {
                    filterAux(list.drop(1), predicate, acc)
                }
            }
        }
    return filterAux(list, predicate, emptyList())
}

fun filterIt(list: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    val destination = mutableListOf<Int>()
    list.forEach { if (predicate(it)) destination.add(it)}
    return destination
}
