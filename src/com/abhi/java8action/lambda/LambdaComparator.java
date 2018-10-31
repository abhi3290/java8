package com.abhi.java8action.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LambdaComparator {
    public static void main(String[] args) {
        List<Developer> developers = new ArrayList<>();

        // sort by age in classic way
        developers.sort(new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        // sort by age in lambda way
        //developers.sort((Developer d1, Developer d2)->d1.getAge() - d2.getAge());

        // sort by age in lambda way + parameter type is optional
        //developers.sort((d1, d2)->d1.getAge()-d2.getAge());

        // sort by age using Comparator provided static methods
        developers.sort(Comparator.comparingInt(Developer::getAge));

        // sort by age with reverse ordering
        developers.sort(Comparator.comparingInt(Developer::getAge).reversed());

        // sort by age with null value of age considered less than any non-null value
        developers.sort(Comparator.nullsFirst(Comparator.comparingInt(Developer::getAge)));

    }
}

