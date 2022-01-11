package part_1_basics.chapter_4_streams;

import part_1_basics.chapter_4_streams.model.Dish;
import part_1_basics.chapter_4_streams.model.MenuUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ExternalAndInternalIterationExercise {
    public static void main(String[] args) {
        // Внешняя итерация
        List<String> dishes1 = new ArrayList<>();
        List<Dish> menu = MenuUtils.getMenu();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            if (dish.getCalories() > 300) {
                dishes1.add(dish.getName());
            }
        }
        System.out.println("highCaloricDishes 1 = " + dishes1);

        // Внутрення итерация
        List<String> dishes2 = new ArrayList<>();
        menu.forEach(dish -> {
            if (dish.getCalories() > 300) {
                dishes2.add(dish.getName());
            }
        });
        System.out.println("highCaloricDishes 2 = " + dishes2);

        // Внутренняя, через потоки
        List<String> dishes3 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("highCaloricDishes 3 = " + dishes3);
    }
}
