import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;

public class AppleSortByColorAndWeight {
    public static void main(String[] args) {
        // Creating apples
        List<Apple> appleList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Apple apple = new Apple(i, (int) (Math.random()*200 + 1));
            if (i % 2 == 0) apple.setColor("green");
            appleList.add(apple);
        }

        System.out.println("Before sort");
        for (Apple apple : appleList) System.out.println(apple);

        System.out.println("After sort by color (green only)");
        List<Apple> greenApplesOnly = filterApples(appleList, Apple::isGreenApple);
        for (Apple apple : greenApplesOnly) System.out.println(apple);

        System.out.println("After sort by weight (heavy only)");
        List<Apple> heavyApplesOnly = filterApples(appleList, Apple::isHeavyApple);
        for (Apple apple : heavyApplesOnly) System.out.println(apple);

        System.out.println("With lambdas (red apples only)");
        List<Apple> redApplesOnly = filterApples(appleList, (Apple a) -> "red".equals(a.getColor()));
        for (Apple apple : redApplesOnly) System.out.println(apple);

        System.out.println("With lambdas (light apples only)");
        List<Apple> lightApplesOnly = filterApples(appleList, (Apple a) -> a.getWeight() < 80);
        for (Apple apple : lightApplesOnly) System.out.println(apple);

        System.out.println("With lambdas (heavy green apples)");
        List<Apple> heavyGreenApplesOnly = filterApples(appleList,
                (Apple a) -> a.getWeight() > 150 && "green".equals(a.getColor()));
        for (Apple apple : heavyGreenApplesOnly) System.out.println(apple);

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
}
