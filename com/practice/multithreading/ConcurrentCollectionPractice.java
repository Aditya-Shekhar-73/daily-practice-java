package practice.multithreading;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollectionPractice {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> hasMap = new ConcurrentHashMap<>();

        hasMap.put("Roll", "1");
        hasMap.put("Name", "Barba");

        hasMap.forEach((key, value) -> System.err.println(key + ": " + value));
    }
}
