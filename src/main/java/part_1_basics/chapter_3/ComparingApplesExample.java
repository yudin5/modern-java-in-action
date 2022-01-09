package part_1_basics.chapter_3;

import part_1_basics.chapter_3.model.Apple;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparingApplesExample {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(100),
                new Apple(200),
                new Apple(400),
                new Apple(50)
        );
        System.out.println("apples before sorting = " + apples);

        // Делаем компаратор в явном виде с помощью comparing - передаём функцию "извлечения ключа" - по чему будем сортировать. То есть вес в данном случае.
        Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
        apples.sort(c);
        System.out.println("apples after sorting = " + apples);

        // Перетряхиваем мешок яблок
        Collections.shuffle(apples);

        // Ну и самый модный вариант
        apples.sort(Comparator.comparing(Apple::getWeight));
        System.out.println("apples after sorting 2 = " + apples);
    }
}
