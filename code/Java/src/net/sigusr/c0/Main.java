package net.sigusr.c0;

import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static int longComputation(int x) {
        return x * x;
    }

    public static IntPredicate parametricPredicate(int x) {
        var c = longComputation(x);
        return y -> y % c == 0;
    }

    public static void main(String[] args) {
        var aStream = IntStream.rangeClosed(0, 100);
        var predicate = parametricPredicate(3);
        IntStream filteredStream = aStream.filter(predicate);
        System.out.println(
                filteredStream.
                        mapToObj(Integer::toString).
                        collect(Collectors.joining(",", "[", "]")));
    }

   // [0,9,18,27,36,45,54,63,72,81,90,99]
}