package com.abhi.java8action.ch2;

import java.util.ArrayList;
import java.util.List;

public class Ch2Test {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();

        List<Apple> greenApples = filterApples(apples, new GreenApplePredicate());
        printApples(apples, new ToStringApplePrinter());

        // using anonymous inner class
        printApples(apples, new ApplePrinter() {
            @Override
            public void print(Apple apple) {
                System.out.println("Apple's color is "+apple.getColor()+" and weight is "+apple.getWeight());
            }
        });
    }

    public static List<Apple> filterApples(List<Apple> apples, String color) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple : apples) {
            if(color.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return  result;
    }

    public static List<Apple> filterApples(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple : apples) {
            if(predicate.test(apple)) {
                result.add(apple);
            }
        }

        return  result;
    }

    public static void printApples(List<Apple> apples, ApplePrinter applePrinter) {
        for(Apple apple : apples) {
            applePrinter.print(apple);
        }
    }
}

