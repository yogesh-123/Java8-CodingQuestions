package com.yogesh.streamapi.miscellaneous;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMiscellanious {
    public static void main(String[] args) {


        //1. Merge two sorted lists into a single sorted list using Java streams:
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> collect = Stream.concat(list1.stream(), list2.stream()).sorted().collect(Collectors.toList());
        //System.out.println(collect);

        //2. Find the intersection of two lists using Java streams:
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list4 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> collect1 = list3.stream()
                .filter(l1->list4.contains(l1))
                .collect(Collectors.toList());
        //System.out.println(collect1);

        //3. Remove duplicates from a list while preserving the order using Java streams:
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        List<Integer> collect2 = numbersWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());
        //System.out.println(collect2);

        //4. Given a list of transactions, find the sum of transaction amounts for each day using Java streams:
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );
        Map<String, Integer> collect3 = transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)));
        //System.out.println(collect3);

        //5. Find the kth smallest element in an array using Java streams:
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k=3;
        int i = Arrays.stream(array)
                .sorted()
                .skip(k - 1)
                .findFirst()
                .orElse(-1);
        //System.out.println(i);

        //6. Given a list of strings, find the frequency of each word using Java streams:
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        Map<String, Long> collect4 = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect4);

        //---Important------7: Write a Java 8 program to find the distinct characters in a list of strings ?
        List<String> strings9 = List.of("apple", "banana", "cherry");
        List<Character> collects = strings9.stream()
                .flatMapToInt(CharSequence::chars)
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(s -> s.getValue() == 1)
                .collect(Collectors.mapping(a -> a.getKey(), Collectors.toList()));
        //System.out.println(collects);

        //---Important------8: Write a Java 8 program to find the second distinct(non repeating) characters in a list of strings ?
        List<String> strings10 = List.of("apple", "banana", "cherry");
        Optional<Map.Entry<Character, Long>> first = strings10.stream()
                .flatMapToInt(CharSequence::chars)
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(s -> s.getValue() == 1)
                .skip(1)
                .findFirst();


        //System.out.println(first.get());


    }
}
