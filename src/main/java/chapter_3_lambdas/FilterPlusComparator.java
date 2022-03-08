package chapter_3_lambdas;

import chapter_3_lambdas.model.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterPlusComparator {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(100, "aa"));
        apples.add(new Apple(150, "bb"));
        apples.add(new Apple(200, "cc"));
        apples.add(new Apple(250, "ee"));
        apples.add(new Apple(300, "dd"));

        apples.sort(Comparator.comparing(Apple::getCountry));
        System.out.println("apples = " + apples);

        // ТАК не получится! Список apples останется без изменений
        // collect - терминальная операция, возвращающая новый список, который просто игнорируется
        apples.stream()
                .filter(apple -> apple.getWeight() > 150)
                .collect(Collectors.toList())
                .sort(Comparator.comparing(Apple::getCountry));

        System.out.println("apples = " + apples);
    }
}
