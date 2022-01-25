package part_1_basics.chapter_5_working_with_streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IterateExample {
    public static void main(String[] args) {

        // Генерация чётных чисел
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // Java 9, добавление предиката. Генерация останавливается, когда условие предиката становится false
        System.out.println("IntStream:");
        IntStream.iterate(0, n -> n < 50, n -> n + 4)
                .forEach(System.out::println);

        // Можно без предиката воспользоваться методом takeWhile
        System.out.println("With takeWhile() method:");
        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 50)
                .forEach(System.out::println);


    }
}
