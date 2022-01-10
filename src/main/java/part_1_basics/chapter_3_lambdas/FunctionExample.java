package part_1_basics.chapter_3_lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two", "three", null, "", "123 4", " ");
//        Function<String, Integer> mapFunction = String::length;
        Function<String, Integer> mapFunction = (String s) -> {
            if (s == null) {
                return 0;
            }
            return s.length();
        };
        List<Integer> stringLengthList = mapStringToLength(strings, mapFunction);
        System.out.println("stringLengthList = " + stringLengthList);
    }

    public static <T, R> List<R> mapStringToLength(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            R nextR = f.apply(t);
            result.add(nextR);
        }
        return result;
    }
}
