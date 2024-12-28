package practice.functional_interface;

import java.util.ArrayList;

/*
 * Practice below Functional Interfaces
 * 1. Predicate
 * 2. Function
 * 3. Consumer
 * 4. Supplier
 */

import java.util.function.*;


public class Practice12 {
    public static void main(String[] args) {
        Predicate<String> isFirstWordUpperCase = word -> {
            if (word.charAt(0) == word.toUpperCase().charAt(0)){
                return true;
            } else {
                return false;
            }
        };

        System.out.println(isFirstWordUpperCase.test("Aditya"));
        System.out.println(isFirstWordUpperCase.test("aditya"));

        Function<Integer, String> toString = number -> number.toString();
        System.out.println(toString.apply(3));

        Consumer<Integer> print = number -> System.out.println("This is the great number of all the time: " + number);
        print.accept(2);

        Supplier<ArrayList<Integer>> getArrayList = ArrayList::new;
        ArrayList<Integer> arrayList = getArrayList.get();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        arrayList.forEach(System.out::println);
    }
}
