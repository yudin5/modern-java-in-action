package part_1_basics.chapter_5_working_with_streams;

import part_1_basics.chapter_4_streams.model.Dish;
import part_1_basics.chapter_4_streams.model.MenuUtils;

import java.util.List;
import java.util.stream.Collectors;

public class TakeWhileDropWhileExample {
    public static void main(String[] args) {
        List<Dish> specialMenu = MenuUtils.getSpecialMenu(); // этот список отсортирован по калорийности
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println("filteredMenu = " + filteredMenu);

        // Так как исходный список отсортирован, то нет необходимости проходиться по всем элементам
        // Java 9
        List<Dish> slicedMenu = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320) // Прекращаем итерацию, как только перестаёт выполняться это условие
                .collect(Collectors.toList());
        System.out.println("filteredMenu2 = " + slicedMenu);

        // Получаем оставшиеся элементы
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println("slicedMenu2 = " + slicedMenu2);
    }
}
