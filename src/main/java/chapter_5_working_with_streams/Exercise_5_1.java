package chapter_5_working_with_streams;

import chapter_4_streams.model.Dish;
import chapter_4_streams.model.MenuUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise_5_1 {
    public static void main(String[] args) {
        List<Dish> menu = MenuUtils.getMenu();
        List<Dish> firstTwoMeatDishes = menu.stream()
                .filter(dish -> Dish.Type.MEAT.equals(dish.getType()))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("firstTwoMeatDishes = " + firstTwoMeatDishes);
    }
}
