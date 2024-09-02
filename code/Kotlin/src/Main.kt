import com.sun.tools.javac.jvm.ByteCodes.ret

fun main() {
    val a = foo(3)
    val b = a(4)
    println(b)

    val c = bar(3)
    val d = c(4)
    println(d)
}

fun foo(x: Int) : (Int) -> Boolean = { y: Int -> x < y }

fun bar(x: Int) : (Int) -> Boolean {
    val c = longComputation(x)
    return { y: Int -> x.mod(y) == 0}
}

fun longComputation(x: Int): Int {
    return x * x
}
