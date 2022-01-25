package chapter_4_streams;

import chapter_4_streams.model.Dish;
import chapter_4_streams.model.MenuUtils;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class GroupingByExample {
    public static void main(String[] args) {
        List<Dish> menu = MenuUtils.getMenu();
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));
        System.out.println("dishesByType = " + dishesByType);
    }
}
