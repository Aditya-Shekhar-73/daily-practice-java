package practice.streams_practice;

/**
 * Practice steam methods
 * 1. Filter
 * 2. Map
 * 3. Reduce
 * 4. Use of Collectors
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice2 {
    public static void main(String[] args) {
        // Filter practice
        List<String> list = Arrays.asList(
            "Barbui", "Puimon", "Pandu", "Adi"
        );

        list.stream()
            .filter(name -> name.startsWith("P"))
            .forEach(System.out::println);

        // Map practice
        List<String> words = Arrays.asList(
            "Barbui", "Puimon", "Pandu", "Adi"
        );

        words.stream()
            .map(word -> "Hallu " + word + "!")
            .forEach(System.out::println);
        
        words.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println);

        // Reduce practice
        List<Integer> numbers = Arrays.asList(
            1, 2, 6, 3, 9, 2
        );

        // New concise way of calling Integer::sum
        int result = numbers.stream().reduce(0, Integer::sum);
        // Traditional way
        int result2 = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(result);
        System.out.println(result2);


        // Collectores use case
        List<String> newList = Arrays.asList(
            "Apple", "Banana", "Mango", "Papaya", "Pinnaple", "Peach"
        );

        List<String> filteredWords = newList.stream().filter(word -> word.startsWith("P")).collect(
            Collectors.toList()
        );

        filteredWords.forEach(System.out::println);
            
    }
}
