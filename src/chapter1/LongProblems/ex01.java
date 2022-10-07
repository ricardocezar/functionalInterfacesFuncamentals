package chapter1.LongProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@FunctionalInterface
interface ToString<T> {
    String convert(T obj);
}

class l2s implements ToString<List<String>>{
    @Override
    public String convert(List<String> obj) {
        return String.join(", ",obj);
    }
}

class m2s implements ToString<Map<String,Integer>>{
    @Override
    public String convert(Map<String,Integer> obj) {
        String mapAsString = obj.keySet().stream()
        .map(key -> key + ":" + obj.get(key))
        .collect(Collectors.joining(", ", "{", "}"));
        return mapAsString;
    }
};

public class ex01 {
    public static void main(String[] args) {
        String a = new l2s().convert(Arrays.asList("a", "b"));
        System.out.println(a);

        Map<String, Integer> map = Map.ofEntries(
            Map.entry("a", 1),
            Map.entry("b", 2)
        );
        String b = new m2s().convert(map);
        System.out.println(b);
    }
}
