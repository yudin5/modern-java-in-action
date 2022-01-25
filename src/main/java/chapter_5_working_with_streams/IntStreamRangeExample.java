package chapter_5_working_with_streams;

import java.util.stream.IntStream;

public class IntStreamRangeExample {
    public static void main(String[] args) {

        // Числовые диапазоны
        IntStream evenNumbers = IntStream.rangeClosed(1, 100) // включительно
                .filter(n -> n % 2 == 0);
        System.out.println("evenNumbers.count() = " + evenNumbers.count());

        IntStream evenNumbersNotClosed = IntStream.range(1, 100) // Не включительно
                .filter(n -> n % 2 == 0);
        System.out.println("evenNumbersNotClosed.count() = " + evenNumbersNotClosed.count());

        IntStream.rangeClosed(-5, 10)
                .filter(n -> n % 3 == 0)
                .filter(n -> n != 0)
                .forEach(System.out::println);

    }
}
