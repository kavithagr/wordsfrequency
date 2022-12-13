package org.example;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class WordsFrequency {
    public static void main(String[] args) {

        // String str = "the cat is in the bag";
        Scanner scanner = new Scanner(System.in);
        //user input from console
        System.out.println("Enter a sentence");
        String str = scanner.nextLine();
        Map<String, Integer> naturalOrderMap = createMapWithString(str);
        Map<String, Integer> descOrderValues = orderByDesc(naturalOrderMap);
        printResult(naturalOrderMap, descOrderValues);
    }

    private static Map<String, Integer> createMapWithString(String str) {
        String[] newStrArray = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < newStrArray.length; i++) {
            if (map.containsKey(newStrArray[i])) {
                map.put(newStrArray[i], map.get(newStrArray[i]) + 1);
            } else {
                map.put(newStrArray[i], 1);
            }
        }
        return map;
    }

    private static Map<String, Integer> orderByDesc(Map<String, Integer> map) {
        Map<String, Integer> orderMapByValue = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> orderMapByValue.put(x.getKey(), x.getValue()));

        return orderMapByValue;
    }

    private static void printResult(Map<String, Integer> naturalOrderMap, Map<String, Integer> descOrderValues) {
        System.out.println("------------------------------------------------------------------------------------ ");
        System.out.println("The output of the given problem statement listing the count and word as key/Pair ");
        System.out.println(naturalOrderMap);
        System.out.println("------------------------------------------------------------------------------------ ");
        System.out.println("The output of the given problem statement in descending order order of the Strings");

        for (Map.Entry<String, Integer> entry : descOrderValues.entrySet()) {
            System.out.println(entry.getValue().toString() + " " + entry.getKey());
        }
        System.out.println("------------------------------------------------------------------------------------ ");
    }

}