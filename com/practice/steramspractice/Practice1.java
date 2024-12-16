package practice.steramspractice;

/**
 * Practice steam methods
 * 1. Filter
 * 2. Map
 * 3. Reduce
 */
import java.util.Arrays;
import java.util.List;


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
    }
}