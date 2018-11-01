package com.abhi.java8action.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Ch5Test {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                //.map((d) -> d.length())
                .collect(toList());
        System.out.println(wordLengths);


        List<Integer> numbers = Arrays.asList(1,2,3,4,6);

        List<Integer> squareOfNumbers = numbers.stream()
                .map(i -> i * i)
                .collect(Collectors.toList());

        System.out.println(squareOfNumbers);

        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(3,4);

        List<int[]> pairs = list1.stream()
                .flatMap(i -> list2.stream()
                        .map(j -> new int[]{i, j})
                )
                .collect(toList());

        System.out.println(pairs);




    }
}
