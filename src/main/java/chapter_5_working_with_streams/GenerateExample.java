package chapter_5_working_with_streams;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateExample {
    public static void main(String[] args) {
        Stream.generate(Math::random)
                .limit(5)
//                .filter(n -> n > 0.99999999)
                .forEach(System.out::println);

        Stream.generate(() -> "123")
                .map(String::length)
                .limit(4)
                .forEach(System.out::println);

        // IntStream
        IntStream ones = IntStream.generate(() -> 1);
        ones
                .limit(3)
                .forEach(System.out::println);

        // С помощью явной реализации IntSupplier
        IntStream twos = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        });
        twos
                .boxed()
                .map(number -> "aaa" + number)
                .limit(3)
                .forEach(System.out::println);

        // Генерация чисел Фибоначчи через IntSupplier, способный хранить состояние
        // Но так лучше не делать
        IntSupplier fib = new IntSupplier() {

            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;

                return oldPrevious;
            }
        };

        IntStream.generate(fib)
                .limit(10)
                .forEach(System.out::println);
    }
}
