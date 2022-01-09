package part_1_basics.chapter_3;

import part_1_basics.chapter_3.model.Apple;

import java.util.function.Predicate;

public class PredicateComposition {
    public static void main(String[] args) {
        Predicate<Apple> heavyApple = apple -> apple.getWeight() > 150;
        boolean test = heavyApple.test(new Apple(200));
        System.out.println("heavyApple = " + test);

        // Отрицание
        Predicate<Apple> notHeavyApple = heavyApple.negate();
        test = notHeavyApple.test(new Apple(200));
        System.out.println("notHeavyApple = " + test);

        // Тяжелое и из России, или лёгкое
        Predicate<Apple> heavyFromRussiaOrNotHeavy =
                heavyApple.and(apple -> "Russia".equals(apple.getCountry()))
                        .or(notHeavyApple);
        test = heavyFromRussiaOrNotHeavy.test(new Apple(150, "Russia"));
        System.out.println("heavyFromRussiaOrNotHeavy = " + test);
    }
}
