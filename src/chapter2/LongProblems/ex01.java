package chapter2.LongProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@FunctionalInterface
interface ToString<T> {
    String convert(T obj);
}

public class ex01 {
    public static void main(String[] args) {
        ToString<List<String>> l2s = x -> String.join(", ", x);
        
        String a = l2s.convert(Arrays.asList("a", "b"));
        System.out.println(a);


        ToString<Map<String,Integer>> m2s = x -> x.keySet()
        .stream()
        .map(key -> key + ":" + x.get(key))
        .collect(Collectors.joining(", ", "{", "}"));

        Map<String, Integer> map = Map.ofEntries(
            Map.entry("a", 1),
            Map.entry("b", 2)
        );
        String b = m2s.convert(map);
        System.out.println(b);
    }
}
