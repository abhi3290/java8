package com.abhi.java8action.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        List<Developer> developers = new ArrayList<>();

        developers.add(new Developer("Abhishek", 300000, 27));
        developers.add(new Developer("Prasun", 400000, 28));

        developers.add(new Developer("Abhishek", 300000, 29));

        List<String> names = developers.stream().map((d) -> d.getName()).collect(Collectors.toList());
        names.forEach(System.out::println);

        List<String> upperNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        upperNames.forEach(System.out::println);


        Map<String, Integer> collect = developers.stream().sorted(Comparator.comparingInt(Developer::getAge).reversed())
                .collect(Collectors.toMap(Developer::getName, Developer::getAge, (old, n) -> old));
        System.out.println(collect);


    }
}
