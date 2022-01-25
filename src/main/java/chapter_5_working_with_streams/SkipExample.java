package chapter_5_working_with_streams;

import chapter_4_streams.model.Dish;
import chapter_4_streams.model.MenuUtils;

import java.util.List;
import java.util.stream.Collectors;

public class SkipExample {
    public static void main(String[] args) {
        List<Dish> specialMenu = MenuUtils.getSpecialMenu();
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(1)
                .collect(Collectors.toList());
        System.out.println("dishes = " + dishes);
    }
}
