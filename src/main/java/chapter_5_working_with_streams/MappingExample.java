package chapter_5_working_with_streams;

import chapter_4_streams.model.Dish;
import chapter_4_streams.model.MenuUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MappingExample {
    public static void main(String[] args) {
        List<Dish> menu = MenuUtils.getMenu();
        // Извлекаем названия блюд
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("dishNames = " + dishNames);

        // Преобразовываем список слов в список с количеством символов в каждом из слов
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("wordLengths = " + wordLengths);

        // Преобразовываем названия блюд в список с количеством символов в каждом из названий
        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("dishNameLengths = " + dishNameLengths);
    }
}
