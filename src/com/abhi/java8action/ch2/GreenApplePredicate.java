package com.abhi.java8action.ch2;

public class GreenApplePredicate implements  ApplePredicate {

    @Override
    public boolean test(Apple a) {
        return "green".equals(a.getColor());
    }
}
