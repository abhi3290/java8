package com.abhi.java8action.ch5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TradesTest {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1. Find all transactions in the year 2011 and sort them by value (small to high).
        List<Transaction> result1 = transactions.stream()
                .filter(d -> d.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println(result1);

        //2. What are all the unique cities where the traders work?

        List<String> result2 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct().collect(Collectors.toList());
        System.out.println(result2);

        //3. Find all traders from Cambridge and sort them by name.

        List<Trader> result3 = transactions.stream()
                .map(t -> t.getTrader())
                .filter(tr -> "Cambridge".equals(tr.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(result3);

        //4. Return a string of all traders’ names sorted alphabetically.
        List<String> result4 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result4);

        //5. Are any traders based in Milan?
        boolean anyTradersInMilanCity = transactions.stream()
                .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println(anyTradersInMilanCity);

        //6. Print all transactions’ values from the traders living in Cambridge.
        transactions.stream()
                    .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                    .map(Transaction::getValue)
                    .forEach(System.out::print);
        System.out.println();

        //7. What’s the highest value of all the transactions?
        Integer maxValueTransaction = transactions.stream()
                .max(Comparator.comparing(Transaction::getValue)).get().getValue();
        System.out.println(maxValueTransaction);

        //8. Find the transaction with the smallest value.
        Transaction minValueTransaction = transactions.stream()
                .reduce((a, b) -> a.getValue() < b.getValue() ? a : b).get();
        System.out.println(minValueTransaction);
    }
}


class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}

class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " +
                "value:" + this.value + "}";
    }
}