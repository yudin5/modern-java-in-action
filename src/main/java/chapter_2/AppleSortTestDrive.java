package chapter_2;

import chapter_2.model.Apple;
import chapter_2.model.AppleFormatter;
import chapter_2.model.ApplePredicate;
import chapter_2.model.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleSortTestDrive {
    public static void main(String[] args) {

        Apple apple1 = new Apple(100, Color.RED);
        Apple apple2 = new Apple(200, Color.RED);
        Apple apple3 = new Apple(170, Color.GREEN);
        Apple apple4 = new Apple(90, Color.GREEN);
        List<Apple> apples = new ArrayList<>(Arrays.asList(apple1, apple2, apple3, apple4));

        List<Apple> greenApples = filterApples(apples, new AppleGreenColorPredicate());
        System.out.println("Green apples:");
        greenApples.forEach(System.out::println);

        System.out.println();

        System.out.println("Fancy apples output:");
        prettyPrintApple(apples, new AppleFancyFormatter());
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String formattedApple = formatter.accept(apple);
            System.out.println(formattedApple);
        }
    }
}
