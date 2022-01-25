package chapter_3_lambdas;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class IntPredicateExample {
    public static void main(String[] args) {

        // Примитив. Без упаковки.
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        System.out.println("evenNumbers.test(1000) = " + evenNumbers.test(1000));
        System.out.println("evenNumbers.test(1001) = " + evenNumbers.test(1001));

        // Объект. С упаковкой.
        Predicate<Integer> evenNumbersInteger = (Integer i) -> i % 2 == 0;
        System.out.println("evenNumbersInteger.test(1000) = " + evenNumbersInteger.test(1000));
        System.out.println("evenNumbersInteger.test(1001) = " + evenNumbersInteger.test(1001));
    }
}
