package coreJava.stream.flatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
   What is Flat Map ?
   In Java, flatMap is a method in the Stream interface.
   It allows you to transform each element of a stream into another stream and
   then flatten all of those streams into a single stream.
   This is particularly useful when dealing with collections of collections.
*/
public class FlatMap {
    public static void main(String[] args) {
        //example1();
        //example2();
        //example3();
        //example4();
        example5();
    }

    private static void example5() {
        List<Integer> numbers = Arrays.asList(123, 456, 789);
        System.out.println("============================================");
        String.valueOf(123).chars().forEach(System.out::println);
        System.out.println("============================================");

        List<String> digits = numbers.stream()
                .map(number -> String.valueOf(number).chars().mapToObj(c -> (char) c))  // Map each number to a stream of its digits
                .flatMap(str -> str.map(String::valueOf))  // Flatten the stream of streams into a single stream of strings
                .collect(Collectors.toList());

        System.out.println(digits); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    private static void example4() {
        String[][] arrayOfArrays = {{"a", "b"}, {"c", "d", "e"}, {"f"}};

        List<String> flattenedList = Arrays.stream(arrayOfArrays)
                .flatMap(Arrays::stream)  // Flatten the array of arrays into a single stream of strings
                .collect(Collectors.toList());

        System.out.println(flattenedList); // Output: [a, b, c, d, e, f]
    }

    private static void example3() {
        List<String> sentences = Arrays.asList("Hello world", "Java is fun");

        List<Character> characters = sentences.stream()
                .flatMap(sentence -> sentence.chars().mapToObj(c -> (char) c))  // Convert each sentence to a stream of characters and flatten
                .collect(Collectors.toList());

        System.out.println(characters);
    }

    private static void example1() {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e"),
                Arrays.asList("f", "g", "h")
        );
        List<String> flattenedList  = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        for (String str : flattenedList){
            System.out.printf(STR." \{str}");
        }
        System.out.println();
    }

    private static void example2() {
        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java is fun",
                "FlatMap is powerful"
        );
        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))  // Split each sentence into words and flatten
                .collect(Collectors.toList());
        for (String str : words){
            System.out.printf(STR." \{str}");
        }
        System.out.println();
    }

}
