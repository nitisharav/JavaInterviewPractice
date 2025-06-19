package capgeminiInterview;

import java.util.*;
import java.util.stream.Collectors;

public class SortMapValuesJava8 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Orange");
        map.put(3, "Banana");

        Map<Integer, String> sortedMap = map.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().toLowerCase()  // optional lowercase
                              .chars()
                              .sorted()
                              .mapToObj(c -> String.valueOf((char) c))
                              .collect(Collectors.joining())
            ));

        sortedMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
//1.

class SortedMapValuesJava8a{
	public static void main(String[] args) {
		Map<Integer, String> map= new HashMap<>();
		map.put(1, "Apple");
		map.put(2, "Orange");
	    map.put(3, "Banana");
	    

        Map<Integer, String> sortedMap = map.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().toLowerCase()  // optional lowercase
                              .chars()
                              .sorted()
                              .mapToObj(c -> String.valueOf((char) c))
                              .collect(Collectors.joining())
            ));
	     sortedMap.forEach((k, v) -> System.out.println(k + " -> " + v)); 			
	}
}