package com.wsai.java8test.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class PuttingIntoPractice {

    public static void main(String[] args){
        //交易员
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        System.out.println("=============");
        //交易
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 500),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)

        );

        //找出2011年的所有交易并按交易额排序（从低到高）
        List<Transaction> tr2011 = transactions.stream()
                .filter((transaction -> transaction.getYear() == 2011))
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(tr2011);

        //交易员都在哪些不同的城市工作过
        List<String> cities = transactions.stream()
                .map((transaction -> transaction.getTrader().getCity()))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities);

        // 查找所有来自于剑桥的交易员，并按姓名排序。
        List<Trader> traders = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(traders);
    }
}
