package practice.streams_practice;

/*
 * Practice streams using below tools
 * 1. Filter
 * 2. Map
 * 3. Reduce
 * 4. Collectors
 */

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Practice10 {
    public static void main(String[] args) {
        // Filter and Collectors
        List<Integer> lst1 = Arrays.asList(56, 23, 87, 96);
        List<Integer> fList = lst1.stream().filter(num -> num instanceof Integer).collect(Collectors.toList());

        fList.forEach(System.out::println);

        // Map
        List<Integer> lst2 = Arrays.asList(56, 23, 87, 96);
        lst2.stream().map(number -> number * 10).forEach(System.out::println);

        // Reduce
        List<Integer> lst3 = Arrays.asList(56, 23, 87, 96);
        int res = lst3.stream().reduce(1, (a, b) -> a * b);
        System.out.println(res);

        // GroupingBy
        List<String> names = Arrays.asList("Adi", "Ame", "Pai", "Pan", "Ani");

        Map<Character, List<String>> map = names.stream().collect(Collectors.groupingBy(word -> word.charAt(0)));
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
