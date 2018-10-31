package com.abhi.java8action.lambda;

import java.util.ArrayList;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<Developer> developers = new ArrayList<>();

        developers.add(new Developer("Abhishek", 300000, 27));
        developers.add(new Developer("Prasun", 400000, 27));

        developers.forEach(System.out::println);
    }
}
