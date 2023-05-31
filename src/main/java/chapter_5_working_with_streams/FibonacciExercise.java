package chapter_5_working_with_streams;

import java.util.stream.Stream;

// Задача: сгенерировать первые 20 элементов последовательности пар Фибоначчи с помощью метода iterate
// (0, 1), (1, 1), (1, 2), (2, 3), (3, 5), (5, 8) и т.д.
public class FibonacciExercise {
    public static void main(String[] args) {

        Stream.iterate(new int[]{0, 1},
                        arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

        // Оставить только числа Фибоначчи
        Stream.iterate(new int[]{0, 1},
                        arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(30)
                .map(arr -> arr[0])
                .forEach(number -> System.out.print(number + " "));
    }
}
