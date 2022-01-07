package part_1_basics.chapter_3;

import part_1_basics.chapter_1.model.Apple;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExamples {
    public static void main(String[] args) {
        // Допустимые лямбда-выражения в Java 8
        Function<String, Integer> stringIntegerFunction = (String s) -> s.length() - 5;
        Predicate<Apple> byWeight = (Apple a) -> a.getWeight() > 150;
        BiConsumer<Integer, Integer> adder = (Integer x, Integer y) -> {
            System.out.println("Result:");
            System.out.println(x + y);
        };
        Supplier<Integer> integerSupplier = () -> 42;

        Comparator<Apple> comparatorByWeight = (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();
        Comparator<Apple> comparatorByWeightSame = Comparator.comparingInt(Apple::getWeight); // То же самое, что и строчка выше
    }
}
