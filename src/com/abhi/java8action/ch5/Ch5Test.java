package com.abhi.java8action.ch5;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Ch5Test {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                //.map((d) -> d.length())
                .collect(toList());
        System.out.println(wordLengths);
    }
}
