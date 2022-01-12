package part_1_basics.chapter_5_working_with_streams;

import part_1_basics.chapter_4_streams.model.Dish;
import part_1_basics.chapter_4_streams.model.MenuUtils;

import java.util.List;
import java.util.stream.Collectors;

public class LimitExample {
    public static void main(String[] args) {
        List<Dish> specialMenu = MenuUtils.getSpecialMenu();
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("dishes = " + dishes);
    }
}
