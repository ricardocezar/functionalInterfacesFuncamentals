package chapter2.LongProblems;

import java.util.Arrays;
import java.util.stream.IntStream;

@FunctionalInterface
interface SumFromZero {
    Integer sum(int number);
}

public class ex03 {
    public static void main(String[] args) {
        SumFromZero test = x -> IntStream.rangeClosed(1, x).sum();
        System.out.println(test.sum(5));
    }
}
