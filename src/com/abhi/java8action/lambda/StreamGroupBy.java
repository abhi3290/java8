package com.abhi.java8action.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGroupBy {
    public static void main(String[] args) {
        List<Developer> developers = new ArrayList<>();

        developers.add(new Developer("Abhishek", 300000, 27));
        developers.add(new Developer("Abhishek", 400000, 30));
        developers.add(new Developer("Prasun", 400000, 27));

        Map<Integer, IntSummaryStatistics> collect = developers.stream().
                collect(Collectors.groupingBy(Developer::getAge, Collectors.summarizingInt(Developer::getSalary)));
        System.out.println(collect);


        Stream<String> stringStream = developers.stream().map((d) -> d.getName()).filter(Objects::nonNull);

    }
}
