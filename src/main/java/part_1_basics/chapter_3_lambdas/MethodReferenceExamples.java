package part_1_basics.chapter_3_lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class MethodReferenceExamples {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a", "b", "A", "B");
        // С учётом регистра
        System.out.println("before sort = " + stringList);
        stringList.sort(String::compareTo);
        System.out.println("after sort = " + stringList);

        // Без учёта регистра
        stringList.sort(String::compareToIgnoreCase);
        System.out.println("after sort ignore case = " + stringList);

        ToIntFunction<String> stringToIntFunction = Integer::parseInt;
        int i = stringToIntFunction.applyAsInt("234");
        System.out.println("i = " + i);

        BiPredicate<List<String>, String> contains = List::contains;
        boolean testContains = contains.test(Arrays.asList("abc", "def"), "abc");
        System.out.println("testContains = " + testContains);

        Predicate<String> startsWithNumberPredicate = MethodReferenceExamples::startsWithNumber;
        boolean testStartsWithNumber = startsWithNumberPredicate.test("1kjl");
        System.out.println("testStartsWithNumber = " + testStartsWithNumber);
        boolean testStartsWithNumber2 = startsWithNumberPredicate.test("s1234");
        System.out.println("testStartsWithNumber2 = " + testStartsWithNumber2);
    }

    private static boolean startsWithNumber(String string) {
        return Character.isDigit(string.charAt(0));
    }
}
