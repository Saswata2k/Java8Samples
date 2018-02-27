package com.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TraderMain {
    public static void main(String[] args) {
        List<Transaction> transactions = getTransactions();
        //doStreamOperations(transactions);
        groupByCurrency(transactions);

    }

    private static void groupByCurrency(List<Transaction> transactions) {
        //Map<Currency,List<Transaction>> groupByMap=transactions.stream().collect(Collectors.groupingBy(Transaction::getValue));
        //for (Map.Entry<Currency,List<Transaction>> entry:)
    }

    private static void doStreamOperations(List<Transaction> transactions) {
        //Find all transactions in the year 2011 and sort them by value (small to high)
        transactions.stream().filter(d -> d.getYear() == 2011).forEach(System.out::println);

        //What are all the unique cities where the traders work?
        transactions.stream().map(d -> d.getTrader().getCity()).distinct().forEach(System.out::println);

        //Find all traders from Cambridge and sort them by name.
        transactions.stream().map(d -> d.getTrader()).filter(d -> d.getCity().equals("Cambridge")).
                distinct().sorted(Comparator.comparing(o -> o.getName())).forEach(System.out::println);

        // Return a string of all traders’ names sorted alphabetically.
        System.out.println("Returning Names : " +transactions.stream().map(d -> d.getTrader().getName()).distinct().collect(Collectors.joining(" ")));

        //Are any traders based in Milan?
        transactions.stream().map(d -> d.getTrader()).filter(d -> d.getCity().equals("Milan")).distinct().forEach(System.out::print);

        // Print all transactions’ values from the traders living in Cambridge.
        transactions.parallelStream().filter(d -> d.getTrader().getCity().equals("Cambridge")).map(d -> d.getValue()).forEach(System.out::println);

        //What’s the highest value of all the transactions?
        Optional<Integer> value = transactions.parallelStream().map(d -> d.getValue()).reduce(Integer::max);
        System.out.println("Max Transaction value is:" + value);

        //Find the transaction with the smallest value.
        Optional<Integer> minValue=transactions.parallelStream().map(d->d.getValue()).reduce(Integer::min);
        System.out.println("Min Transaction value is:" + minValue);
    }

    private static List<Transaction> getTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }
}
