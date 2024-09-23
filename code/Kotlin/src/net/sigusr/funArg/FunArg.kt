package net.sigusr.funArg

fun main() {
    println(consall("beat", listOf("harvard", "yale")))
}

fun <T, U> map(fn: (T) -> U, x: List<T>): List<U> =
    when {
        x.isEmpty() -> emptyList()
        else -> listOf(fn(x.first())) + map(fn, x.drop(1))
    }

fun <T> consall(x: T, ys: List<T>) = map({ y -> listOf(x, y) }, ys)
