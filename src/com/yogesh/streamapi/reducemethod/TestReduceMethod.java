package com.yogesh.streamapi.reducemethod;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class TestReduceMethod {
    public static void main(String[] args) {

        //1. Get the Longest String
        List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

        Optional<String> reduce = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
        //System.out.println(reduce.get());

        //2. Combine Strings
        String[] array = { "Geeks", "for", "Geeks" };
        Optional<String> reduce1 = Arrays.stream(array)
                .reduce((str1, str2) -> str1 + "_" + str2);
        //System.out.println(reduce1.get());

        //3. Sum of All Elements
        List<Integer> numbers = Arrays.asList(-2, 0, 4, 6, 8);
        Integer reduce2 = numbers.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        //System.out.println(reduce2);

        //4: Product of All Numbers in a Range
        int product = IntStream.range(2, 8)
                .reduce(1,(n1,n2)->n1*n2);
        System.out.println(product);

    }
}
