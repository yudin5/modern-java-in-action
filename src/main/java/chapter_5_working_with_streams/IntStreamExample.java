package chapter_5_working_with_streams;

import chapter_4_streams.model.Dish;
import chapter_4_streams.model.MenuUtils;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamExample {
    public static void main(String[] args) {
        List<Dish> menu = MenuUtils.getMenu();
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("calories = " + calories);

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> boxed = intStream.boxed(); // Возврат к Integer

        OptionalInt optionalIntMax = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println("optionalIntMax = " + optionalIntMax);

        int max = optionalIntMax.orElse(0);
        System.out.println("max = " + max);

    }
}
