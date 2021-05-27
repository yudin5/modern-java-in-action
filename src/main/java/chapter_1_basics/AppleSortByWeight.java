package chapter_1_basics;

import model.Apple;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class AppleSortByWeight {
    public static void main(String[] args) {

        // Creating apples
        List<Apple> appleList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Apple apple = new Apple(i, (int) (Math.random()*200 + 1));
            appleList.add(apple);
        }

        //TODO: just for test
        System.out.println("*** Before sort");
        showApples(appleList);

        // Old style - before Java 8
//        Collections.sort(appleList, new Comparator<model.Apple>() {
//            public int compare(model.Apple a1, model.Apple a2) {
//                return a1.getWeight() - a2.getWeight();
//            }
//        });

        // New style - Java 8
        System.out.println("*** After sort by weight");
        appleList.sort(comparing(Apple::getWeight));
        appleList.forEach(System.out::println);

        System.out.println("*** After sort by number");
        appleList.sort(comparing(Apple::getNumber));
        showApples(appleList);

    }

    private static void showApples(List<Apple> list) {
        for (Apple apple : list) {
            System.out.println(apple);
        }
    }
}
