package com.abhi.java8action.ch3;

import com.abhi.java8action.ch2.Apple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Ch3Test {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();

        filter(apples, (a) -> a.getWeight() > 150);

        sort(apples, (a1, a2) -> a1.getWeight() - a2.getWeight());
        sort(apples, Comparator.comparing((a) -> a.getWeight()));
        sort(apples, Comparator.comparing(Apple::getWeight));

    }



    public static <T> List<T> filter(List<T> collections, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for(T item : collections) {
            if(predicate.test(item)) {
                result.add(item);
            }
        }

        return  result;
    }

    public static <T> List<T> sort(List<T> collections, Comparator<T> comparator) {
        Collections.sort(collections, comparator);
        return  collections;
    }
}
