package com.abhi.java8action.ch5;

import com.abhi.java8action.ch4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreamTest {
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

        int sum = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
                //.max();
        System.out.println(sum);


        System.out.println("Generating even numbers between 1 to 10");
        IntStream.rangeClosed(1, 10).filter(i -> i%2 == 0).forEach(System.out::println);


        System.out.println("Generating 10 even numbers");
        Stream.iterate(0, n -> n+2).limit(10).forEach(System.out::println);

        System.out.println("Generating 10 fibonacci numbers");
        Stream.iterate(new int[]{0,1}, t-> new int[]{t[1], t[0]+t[1]}).limit(10)
                .forEach(t-> System.out.println("("+t[0]+", "+t[1]+")"));


        System.out.println("Generating stream of number 2");
        Stream.generate(() -> 2).limit(5).forEach(System.out::println);
    }
}
