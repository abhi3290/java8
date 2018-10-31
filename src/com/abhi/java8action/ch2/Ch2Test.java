package com.abhi.java8action.ch2;

import java.util.ArrayList;
import java.util.List;

public class Ch2Test {
    public static void main(String[] args) {

    }


    public List<Apple> filterApplies(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple : apples) {
            if(predicate.test(apple)) {
                result.add(apple);
            }
        }

        return  result;
    }

    public void printApples(List<Apple> apples, ApplePrinter applePrinter) {
        for(Apple apple : apples) {
            applePrinter.print(apple);
        }
    }
}

