package com.abhi.java8action.ch3;

import com.abhi.java8action.ch2.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ch3Test {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();

        filter(apples, (a) -> a.getWeight() > 150);
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
}
