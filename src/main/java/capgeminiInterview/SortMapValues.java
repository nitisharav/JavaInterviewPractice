package capgeminiInterview;

import java.util.*;

public class SortMapValues {
    public static void main(String[] args) {
        Map<Integer, String> originalMap = new HashMap<>();
        originalMap.put(1, "Apple");
        originalMap.put(2, "Orange");
        originalMap.put(3, "Banana");

        Map<Integer, String> resultMap = new HashMap<>();

        for (Map.Entry<Integer, String> entry : originalMap.entrySet()) {
            String value = entry.getValue().toLowerCase(); // optional: lowercase
            char[] chars = value.toCharArray();
            Arrays.sort(chars);
            resultMap.put(entry.getKey(), new String(chars));
        }

        // Print the result
        for (Map.Entry<Integer, String> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

