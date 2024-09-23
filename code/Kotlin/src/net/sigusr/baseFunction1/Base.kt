package net.sigusr.baseFunction1

fun main() {

    val aList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val sieve: (Int) -> Boolean = parametricSieve(3)
    println(filter(aList, sieve))
}

fun parametricSieve(x: Int): Function1<Int, Boolean> {
    val c = longComputation(x)
    return object : Function1<Int, Boolean> {
        override fun invoke(y: Int) = c % y == 0
    }
}

fun longComputation(x: Int): Int {
    return x * x
}

fun filter(list: List<Int>, predicate: Function1<Int, Boolean>): List<Int> {
    fun filterAux(list: List<Int>, predicate: (Int) -> Boolean, acc: List<Int>): List<Int> =
        when (list.isEmpty()) {
            true -> acc
            false -> {
                val first = list.first()
                if (predicate.invoke(first)) {
                    filterAux(list.drop(1), predicate, acc + first)
                } else {
                    filterAux(list.drop(1), predicate, acc)
                }
            }
        }
    return filterAux(list, predicate, emptyList())
}
