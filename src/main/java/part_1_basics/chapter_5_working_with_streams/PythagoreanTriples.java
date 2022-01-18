package part_1_basics.chapter_5_working_with_streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriples {
    public static void main(String[] args) {

        // Пифагоровы тройки. Стороны прямоугольного треугольника. Пример: (3, 4, 5)
        // Должны удовлетворять условию: (a, b, c) ---> a * a + b * b = c * c

        // Есть 2 числа - a, b. Подходят ли они для пифагоровых троек?
        // Проверяем, чтобы квадратный корень из (a * a + b * b) был целым числом
//        int a = 3;
//        int b = 4;
//        boolean celoe = Math.sqrt(a * a + b * b) % 1 == 0;
//        System.out.println("celoe = " + celoe);


//        int a = 3;
//        Stream<int[]> stream = IntStream.rangeClosed(1, 100)
//                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});
//        stream.collect(Collectors.toList()).forEach(
//                t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2])
//        );

//        int a = 1;
//        Stream<int[]> stream = IntStream.rangeClosed(1, 100)
//                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//                .boxed()
//                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});


        // Теперь генерируем сами значения "а"
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        System.out.println("Results:");
        pythagoreanTriples.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        // Более оптимальный вариант решения, чтобы не вычислять квадратный корень 2 раза
        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0));
        System.out.println("Results 2:");
        pythagoreanTriples2.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));


    }
}
