package chapter_4_streams;

import chapter_4_streams.model.Dish;
import chapter_4_streams.model.MenuUtils;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ThreeHighCaloricDishNames {
    public static void main(String[] args) {
        List<Dish> menu = MenuUtils.getMenu();
        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        System.out.println("threeHighCaloricDishNames = " + threeHighCaloricDishNames);
    }
}
