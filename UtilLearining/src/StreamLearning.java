//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLearning {
    public StreamLearning() {
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = (List)strings.stream().filter((string) -> {
            return !string.isEmpty();
        }).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = (String)strings.stream().filter((string) -> {
            return !string.isEmpty();
        }).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = (List)numbers.stream().map((i) -> {
            return i * i;
        }).distinct().collect(Collectors.toList());
        System.out.println(squaresList);
        List<String> string2 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        long count = string2.parallelStream().filter((string) -> {
            return string.isEmpty();
        }).count();
        System.out.println(count);


    }
}
