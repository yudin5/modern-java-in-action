package chapter_5_working_with_streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamOfExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        Stream<Object> emptyStream = Stream.empty();
        emptyStream.map(Object::hashCode).forEach(System.out::println);

        Object o = new Object();
        Stream<Object> objectStream = Stream.of(o);
        objectStream.map(Object::hashCode).forEach(System.out::println);

        // Пример ofNullable
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream = homeValue == null ? Stream.empty() : Stream.of(homeValue);

        Stream<String> values = Stream.of("config", "home", "user")
                .flatMap(key -> Stream.of(System.getProperty(key)));
        values.forEach(System.out::println); // в выводе null, null, null

        Stream<String> valuesOfNullable = Stream.of("config", "home", "user")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));
        valuesOfNullable.forEach(System.out::println); // в выводе пусто

        // Создание потока из массива
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("sum = " + sum);

        double[] doubleNumbers = {21.55, 2, 3.654, 17.003};
        double average = Arrays.stream(doubleNumbers).average().orElse(0);
        System.out.println("average = " + average);
    }
}
