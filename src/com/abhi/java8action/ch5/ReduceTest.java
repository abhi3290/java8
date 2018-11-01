package com.abhi.java8action.ch5;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        Integer totalSum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(totalSum);

        Integer max = numbers.stream().reduce(0, Integer::max);
        System.out.println(max);

        long count = numbers.stream().count();
        System.out.println(count);
    }
}
