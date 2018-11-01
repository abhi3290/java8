package com.abhi.java8action.ch6;

import com.abhi.java8action.ch4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class GroupingTest {
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

        Map<Dish.Type, List<Dish>> menuByCurrency = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(menuByCurrency);

        Map<Dish.Type, Long> countByDishType = menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(countByDishType);

        Map<Dish.Type, Optional<Dish>> maxCaloriesDishInTypeOptional = menu.stream().collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
        System.out.println(maxCaloriesDishInTypeOptional);

        Map<Integer, Dish> maxCaloriesDishInType = menu.stream().collect(groupingBy(Dish::getCalories, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(maxCaloriesDishInType);
    }
}
