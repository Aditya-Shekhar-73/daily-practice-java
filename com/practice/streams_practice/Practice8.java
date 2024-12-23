package practice.streams_practice;

import java.util.Arrays;
import java.util.List;

/*
 * Practice streams using below tools
 * 1. Filter
 * 2. Map
 * 3. Reduce
 * 4. Collectors
 */

import java.util.stream.Collectors;


public class Practice8 {
    public static void main(String[] args) {
        // Filter and Collectors.toList()
        List<String> lst1 = Arrays.asList(
            "ABC", "BCD", "ACB"
        );

        List<String> fList = lst1.stream().filter(word -> word.startsWith("A")).collect(Collectors.toList());
        fList.forEach(System.out::println);

        // Map
        List<Integer> ls2 = Arrays.asList(
            1, 6, 3, 7, 10
        );
        ls2.stream().map(num -> num * num + 1).forEach(System.out::println);

        // Reduce
        List<Integer> numbers = Arrays.asList(1, 7, 8, 3);
        int result = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(result);
    }
}
