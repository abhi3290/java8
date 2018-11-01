package com.abhi.java8action.ch5;

import com.abhi.java8action.ch4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindingMatchingTest {
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


        boolean anyOneVegetarian = menu.stream()
                                        .anyMatch(m -> {
                                            System.out.println("Checking if "+m.getName() +" is vegetaria or not ?");
                                            return m.isVegetarian();
                                        });

        System.out.println("Any one vegetarian or not ? "+ anyOneVegetarian);


        Optional<Dish> anyVegetarian = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        System.out.println("Any one is vegetarian ?"+anyVegetarian.isPresent());


        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny().ifPresent((d) -> System.out.println("At least one vegetarian "+d.getName()+" is present"));
    }
}
