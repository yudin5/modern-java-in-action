package chapter_3_lambdas;

import chapter_3_lambdas.model.Apple;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorComposition {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(100, "Russia"),
                new Apple(200, "USA"),
                new Apple(400, "China"),
                new Apple(50, "Brazil"),
                new Apple(100, "Poland"),
                new Apple(100, "Austria")
        );
        System.out.println("apples before sorting = " + apples);

        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println("apples after sorting by weight reversed = " + apples);

        Collections.shuffle(apples);

        apples.sort(Comparator.comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getCountry));
        System.out.println("apples after sorting by weight reversed AND THEN by country = " + apples);

    }
}
