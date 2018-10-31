package com.abhi.java8action.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    public static void main(String[] args) {
        List<Developer> developers = new ArrayList<>();

        developers.add(new Developer("Abhishek", 300000, 27));
        developers.add(new Developer("Prasun", 400000, 28));

        Developer developer = developers.stream().filter((d) -> d.getAge() > 27).findAny().orElse(null);
        System.out.println("First developer who has age > 27 : "+developer);

        String abhishekName = developers.stream().filter((d) -> d.getName().equals("Abhishek")).findFirst().get().getName();
        System.out.println("Find developer who has name as Abhishek : "+abhishekName);

        List<String> names = developers.stream().map((d) -> d.getName()).collect(Collectors.toList());
        names.forEach(System.out::println);

        List<String> upperNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        upperNames.forEach(System.out::println);
    }
}
