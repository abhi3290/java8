package com.abhi.java8action.ch3;

import com.abhi.java8action.ch2.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ch3Test {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();

        filter(apples, (a) -> a.getWeight() > 150);

        sort(apples, (a1, a2) -> a1.getWeight() - a2.getWeight());

        sort(apples, Comparator.comparing((a) -> a.getWeight()));
        sort(apples, Comparator.comparing(Apple::getWeight));

        List<String> str = Arrays.asList("a","b","A","B");

        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        str.sort(String::compareToIgnoreCase);

        //(args) -> ClassName.staticMethod(args); Method Reference- ClassName::staticMethod
        Function<String, Integer> staticFunction = (s) -> Integer.parseInt(s);
        Function<String, Integer> staticFunction1 = Integer::parseInt;

        // (arg0, rest) -> arg0.instanceMethod(rest); Method reference- ClassNameOfArgo::instanceMethod
        Comparator<String> instanceFunction = (a ,b) -> a.compareToIgnoreCase(b);
        Comparator<String> instanceFunction1 = (a ,b) -> a.compareToIgnoreCase(b);

        // (argo0) -> expr.instanceMethod(argo); Method reference - expr::instanceMethod

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
