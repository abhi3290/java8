package com.abhi.java8action.ch5;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlatMapTest {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<String> distinctWords = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());


        System.out.println(distinctWords);
    }
}
