package net.sigusr;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Main {

    public static int longComputation(int x) {
        return x * x;
    }

    public static IntPredicate parametricPredicate(int x) {
        int c = longComputation(x);
        return (int y) -> y % c == 0;
    }

    public static void main(String[] args) {
        IntStream aStream = IntStream.rangeClosed(0,100);
        IntPredicate predicate = parametricPredicate(3);
        System.out.println(aStream.filter(predicate));
    }
}