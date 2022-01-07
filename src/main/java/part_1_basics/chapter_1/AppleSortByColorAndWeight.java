package part_1_basics.chapter_1;

import part_1_basics.chapter_1.model.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppleSortByColorAndWeight {
    public static void main(String[] args) {
        // Creating apples
        List<Apple> appleList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Apple apple = new Apple(i, (int) (Math.random() * 200 + 1));
            if (i % 2 == 0) apple.setColor("green");
            appleList.add(apple);
        }

        System.out.println("Before sort");
        for (Apple apple : appleList) System.out.println(apple);

        System.out.println("After sort by color (green only)");
        List<Apple> greenApplesOnly = filterApples(appleList, Apple::isGreenApple);
        showApples(greenApplesOnly);

        System.out.println("After sort by weight (heavy only)");
        List<Apple> heavyApplesOnly = filterApples(appleList, Apple::isHeavyApple);
        showApples(heavyApplesOnly);

        System.out.println("With lambdas (red apples only)");
        List<Apple> redApplesOnly = filterApples(appleList, (Apple a) -> "red".equals(a.getColor()));
        showApples(redApplesOnly);

        System.out.println("With lambdas (light apples only)");
        List<Apple> lightApplesOnly = filterApples(appleList, (Apple a) -> a.getWeight() < 80);
        showApples(lightApplesOnly);

        System.out.println("With lambdas (heavy green apples)");
        List<Apple> heavyGreenApplesOnly = filterApples(appleList, (Apple a) -> a.getWeight() > 150 && "green".equals(a.getColor()));
        showApples(heavyGreenApplesOnly);
        Predicate<Apple> heavyGreenAppliePredicat = (Apple a) -> a.getWeight() > 150 && "green".equals(a.getColor());
        heavyGreenApplesOnly.forEach(System.out::println);

        Predicate<Apple> orangeApplePredicate = (Apple a) -> "orange".equals(a.getColor());
        List<Apple> orangeApples = filterApples(appleList, orangeApplePredicate);
        System.out.println("Orange apples:");
        orangeApples.forEach(System.out::println);

        System.out.println("Only red apples, sorted by weight");
        List<Apple> redApples = filterApples(appleList, Apple::isRedApple).stream()
                .filter(apple -> apple.getWeight() > 10)
                .sorted(Comparator.comparing(Apple::getWeight))
                .collect(Collectors.toList());
        showApples(redApples);
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    private static List<Apple> filterApples(List<Apple> appleList, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static void showApples(List<Apple> list) {
        for (Apple apple : list) {
            System.out.println(apple);
        }
    }
}
