package com.abhi.java8action.ch4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ch4Test {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 200, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        List<String> names = menu.stream()
                                    .filter(d -> {
                                        System.out.println("Filtering "+d.getName());
                                        return d.getCalories() > 300;})
                                    //.sorted(Comparator.comparing(Dish::getCalories))
                                    .map(m -> {
                                        System.out.println("Mapping "+m.getName());
                                        return m.getName(); })
                                    .limit(3)
                                    .collect(Collectors.toList());

        System.out.println(names);

    }
}
