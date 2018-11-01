package com.abhi.java8action.ch6;

import com.abhi.java8action.ch4.Dish;

import java.util.*;

import java.util.stream.Collectors;
import java.util.Comparator.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class ReduceSummarizeTest {
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

        Optional<Dish> maxCaloriesDish = menu.stream().collect(maxBy(comparing(Dish::getCalories)));
        System.out.println("Max calories Dish : "+maxCaloriesDish.get());

        Integer totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("Total calories of Dishes : "+totalCalories);

        IntSummaryStatistics caloriesMathSummary = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("Calories Summary : "+caloriesMathSummary);

        String allDishes = menu.stream().map(Dish::getName).collect(joining(","));
        System.out.println("Dishes : "+allDishes);

        int totalCalories1 = menu.stream().collect(reducing(
                0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("Total Calories : "+totalCalories1);
    }
}
