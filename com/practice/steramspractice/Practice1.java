package practice.steramspractice;

/**
 * Practice steam methods
 * 1. Filter
 * 2. Map
 * 3. Reduce
 * 4. Use of Collectors
 */
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Practice1 {
    public static void main(String[] args) {
        // Implementing Filter
        List<String> lst = Arrays.asList(
            "Aditya", "Barbie", "Paimon", "Panda"
        );

        lst.stream()
        .filter(name -> name.startsWith("P"))
        .forEach(System.out::println);

        // Implementing Map Function
        List<String> myList = Arrays.asList(
            "Python", "Java", "Roby"
        );

        myList.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println);

        // Implementing Reduce function
        List<Integer> numbers = Arrays.asList(
            1, 2, 5, 2, 8, 8
        );

        int sum = numbers.stream()
                    .reduce(0, Integer::sum);
        
        System.out.println(sum);

        // Using Collectors
        List<String> words = Arrays.asList(
            "Banana", "Apple", "Mango", "Lichi", "Pea"
        );

        List<String> filteredWords = words.stream()
            .filter(word -> word.length() > 4)
            .collect(Collectors.toList());

        System.out.println(filteredWords);

        // Using GroupingBy of Collectors
        List<String> names = Arrays.asList(
            "Aditya", "Barbie", "Paimon", "Panda"
        );

        Map<Character, List<String>> groupedNames = names.stream()
                                                        .collect(Collectors.groupingBy(name -> name.charAt(0)));
        
        System.out.println(groupedNames);
    }
}