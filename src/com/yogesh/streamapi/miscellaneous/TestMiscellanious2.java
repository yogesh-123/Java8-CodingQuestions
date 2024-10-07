package com.yogesh.streamapi.miscellaneous;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestMiscellanious2 {

    public static void main(String[] args) {

        //1. Write a Java 8 program to filter even numbers from a list ?
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        //System.out.println(collect);

        // 2: Write a Java 8 program to calculate the sum of integers in a list ?
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = numbers2.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        //System.out.println(reduce);

        //Write a Java 8 program to find the maximum element from a list ?
        List<Integer> numbers3 = List.of(3, 7, 2, 9, 5);
        OptionalInt max = numbers3.stream()
                .mapToInt(n -> n)
                .max();
        //System.out.println(max.getAsInt());

        //4: Write a Java 8 program to check if a list contains a specific element ?
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5);
        int targetNumber=9;
        boolean b = numbers4.stream()
                .anyMatch(n -> n == targetNumber);
        //System.out.println(b);

        // 5: Write a Java 8 program to find the sum of all even numbers in a list of integers ?
        List<Integer> numbers5 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce1 = numbers5.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, (n1, n2) -> n1 + n2);
        //System.out.println(reduce1);

        // 6: Write a Java 8 program to concatenate all strings in a list ?
       List<String> stringList= List.of("Hello", " ", "World", "!");
        Optional<String> reduce2 = stringList.stream()
                .reduce((word1, word2) -> word1 + "" + word2);
        //System.out.println(reduce2.get());

        //second way
        String collect1 = stringList
                .stream()
                .collect(Collectors.joining());
       // System.out.println(collect1);

        //7: Write a Java 8 program to find the average length of strings in a list of strings?
        List<String> strings = List.of("apple", "banana", "orange", "grape", "kiwi");
        Double collect2 = strings.stream()
                .collect(Collectors.averagingDouble(String::length));
        //System.out.println(collect2);

        //8: Write a Java 8 program to count the occurrences of a given character in a list of strings?
        List<String> strings2 = List.of("apple", "banana", "cherry");
        long count = strings2.stream()
                .flatMapToInt(CharSequence::chars)
                .filter(ch -> ch == 'a')
                .count();
        //System.out.println(count);
      //8b: Write a Java 8 program to count the occurrences of  characters in a list of strings?
      List<String> strings23 = List.of("apple", "banana", "cherry");

      Map<Character, Long> collects = strings2.stream()
             .flatMapToInt(CharSequence::chars)
             .mapToObj(ch -> (char) ch)
             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
      System.out.println(collects);

        //9. Java 8 Program to Count Characters in a String
        String input="Java 8 Streams";
        Map<Character, Long> collect3 = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        //System.out.println(collect3);

        //9: Write a Java 8 program to check if all elements in a list are greater than a given value?
        List<Integer> numbers6 = List.of(10, 20, 30, 40, 50);
        boolean b1 = numbers6.stream()
                .allMatch(n -> n > 25);
        //System.out.println(b1);

        //10: Write a Java 8 program to find the factorial of a given number ?
        int n=5;
        int reduce3 = IntStream.rangeClosed(1, n)
                .reduce(1, (a, c) -> a * c);
        //System.out.println(reduce3);

        //11: Write a Java 8 program to convert all strings to uppercase in a list ?
        List<String> strings4 = List.of("apple", "banana", "cherry");
        List<String> collect4 = strings4.stream().
                map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        //System.out.println(collect4);


        //12: Write a Java 8 program to sort a list of strings in alphabetical order ?
        List<String> strings6 = List.of("banana", "apple", "cherry");
        List<String> collect5 = strings6.stream()
                .sorted(Comparator.comparing(Function.identity())).collect(Collectors.toList());
        //System.out.println(collect5);

        //---Important------13: Write a Java 8 program to convert a list of integers to a comma-separated string
        List<Integer> numbers7 = List.of(1, 2, 3, 4, 5);
        String collect6 = numbers7.stream()
                .map(q -> q.toString())
                .collect(Collectors.joining(","));
        //System.out.println(collect6);

        //14: Write a Java 8 program to find the second smallest element in a list of integers ?
        List<Integer> numbers8 = List.of(3, 1, 4, 2, 5);
        Optional<Integer> first = numbers8.stream()
                .sorted()
                .skip(2 - 1)
                .findFirst();
        //System.out.println(first.get());

        //---Important------15: Write a Java 8 program to find the frequency of each word in a list of strings?
        List<String> words = List.of("apple banana apple", "banana cherry", "apple banana cherry");
        Map<String, Long> collect7 = words.stream()
                .flatMap(line -> List.of(line.split("\\s+")).stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(collect7);

        //16.Java 8 Program to Find the Sum of All Digits of a Number
        String numbers10="12345";
        int sum = numbers10.chars()
                .map(Character::getNumericValue)
                .sum();
        //System.out.println(sum);


        //---Important------17.Write a Java 8 program to find the sum of digits of a list of integers?
        List<Integer> numbers9 = List.of(123, 456, 789);
        int sum1 = numbers9.stream()
                .mapToInt(t -> String.valueOf(t).chars().map(Character::getNumericValue).sum())
                .sum();
        //System.out.println(sum1);

        //---Important------18: Write a Java 8 program to find the distinct characters in a list of strings ?
        List<String> strings9 = List.of("apple", "banana", "cherry");
        Set<Character> collect8 = strings9.stream()
                .flatMapToInt(s -> s.chars())
                //.peek(System.out::println)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        System.out.println(collect8);

        //19: Write Java 8 program to find all the numbers starting with 2 in given list ?
        List<Integer> numbers11 = Arrays.asList(223, 234, 145, 367, 289, 2001, 2289);
        List<Integer> collect9 = numbers11.stream()
                .filter(n12 -> String.valueOf(n12).startsWith("2"))
                .collect(Collectors.toList());
        //System.out.println(collect9);

        //20: Write a Java 8 program to find the distinct characters in a list of strings ?
        List<String> strings11 = List.of("apple", "banana", "cherry");
        Set<Character> collect10 = strings11.stream()
                .flatMapToInt(a -> a.chars())
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());
        //System.out.println(collect10);

        //21 Write Java 8 program to count the total numbers of elements in the given integers list ?
        List<Integer> numbers12 = Arrays.asList(10, 20, 30, 40, 50);
        long count1 = numbers12.stream()
                .count();
        //System.out.println(count1);

        //22 : Write Java 8 program to check if given integer array contains duplicate or not.
        // Return true if it contains duplicate character.
        int[] nums = {1, 2, 3, 4,5, 5};
        boolean b2 = Arrays.stream(nums)
                .boxed()
                .distinct()
                .count() != nums.length;
        //System.out.println(b2);

        //23.  Write Java 8 program to separate odd and even numbers from the given list of integers?
        List<Integer> numbers13 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> collect11 = numbers13.stream()
                .collect(Collectors.partitioningBy(z -> z % 2 == 0));
        //System.out.println("Even Number "+collect11.get(true));
        //System.out.println("Odd Number "+collect11.get(false));

        //24. Write Java 8 program to merge two unsorted arrays into single sorted array?
        int[] arr1 = {3, 6, 8, 10, 10};
        int[] arr2 = {1, 2, 4, 5};

        int[] array = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .sorted()
                .toArray();
        //System.out.println(Arrays.toString(array));

        //25.Java program to get first three maximum numbers and three minimum numbers from the given list of integers?
        List<Integer> numbers14 = Arrays.asList(10, 5, 20, 15, 25, 3, 30, 1, 8);
        List<Integer> collect12 = numbers14.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        //System.out.println(collect12);

        //26.Java 8 program to check if two strings are anagrams or not?
        String str1 = "listen".toLowerCase();
        String str2 = "silent".toLowerCase();

        String reduce4 = Arrays.stream(str1.split("")).sorted().reduce("", (s1, s2) -> s1 + s2);
        String reduce5 =Arrays.stream(str2.split("")).sorted().reduce("", (s1, s2) -> s1 + s2);
        if(reduce4.equals(reduce5)){
            //System.out.println("String are anagram");
        }

        //-----Important----27 : Write Java 8 program to sort given list of strings according to decreasing order of their length?
        List<String> strings7 = Arrays.asList("banana", "apple", "orange", "grape", "kiwi");
        List<String> collect13 = strings7.stream()
                .sorted((s1, s2) -> Integer.compare(s2.length(), s1.length()))
                .collect(Collectors.toList());
        //System.out.println(collect13);

        //28 Write Java 8 program to print the most repeated element in an array?
        int[] array2 = {1, 2, 3, 4, 2, 2, 3, 4, 4, 4, 5, 5, 4};
        Map.Entry<Integer, Long> arraysIsEmpty = Arrays.stream(array2)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new IllegalArgumentException("Arrays is empty"));
       // System.out.println(arraysIsEmpty.getKey()+" "+arraysIsEmpty.getValue());

        //29. find the nth highest salary

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("anil", 1400);
        map1.put("bhavna", 1300);
        map1.put("micael", 1500);
        map1.put("tom", 1600);//output
        map1.put("ankit", 1200);
        map1.put("daniel", 1700);
        map1.put("james", 1400);


     Map.Entry<Integer, List<String>> integerListEntry = map1.entrySet().stream()
             .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
             .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
             .collect(Collectors.toList()).get(1);
     System.out.println(integerListEntry);


    }
}
