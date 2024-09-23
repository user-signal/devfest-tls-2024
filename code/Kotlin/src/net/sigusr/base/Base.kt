package net.sigusr.base

fun main() {

    val aList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println(aList.filter { it % 2 == 0 })

    println(net.sigusr.baseFunction1.filter(aList) { it % 2 == 0 })
    println(net.sigusr.baseFunction1.filter(aList, { it % 2 == 0 }))
    println(net.sigusr.baseFunction1.filter(aList, { someInt -> someInt % 2 == 0 }))

    val sieve: (Int) -> Boolean = net.sigusr.baseFunction1.parametricSieve(3)
    println(net.sigusr.baseFunction1.filter(aList, sieve))

    val sieveCurried: (Int) -> Boolean = parametricSieveCurried(3)
    println(net.sigusr.baseFunction1.filter(aList, sieveCurried))
}

fun parametricSieve(x: Int): (Int) -> Boolean {
    val c = net.sigusr.baseFunction1.longComputation(x)
    return { y -> c % y == 0 }
}

val parametricSieveCurried: (Int) -> (Int) -> Boolean = { x ->
    val c = net.sigusr.baseFunction1.longComputation(x);
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

fun filter(list: List<Int>, predicate: (Int) -> Boolean): List<Int> {
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
