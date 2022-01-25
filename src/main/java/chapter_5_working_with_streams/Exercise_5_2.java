package chapter_5_working_with_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise_5_2 {
    public static void main(String[] args) {
        // Вернуть квадраты этих чисел
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = listOfNumbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
        System.out.println("squares = " + squares);

        // По двум спискам чисел вернуть их попарные значения
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4, 5);

        // Решение 1
        List<List<Integer>> result = new ArrayList<>();
        numbers1
                .forEach(number1 -> {
                    numbers2.forEach(number2 -> {
                        List<Integer> internalList = Arrays.asList(number1, number2);
                        result.add(internalList);
                    });
                });
        System.out.println("result = " + result);

        // Решение 2, через flatMap
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(number1 -> numbers2.stream()
                                .map(number2 -> new int[]{number1, number2}))
                        .collect(Collectors.toList());
        System.out.println("pairs = " + pairs);

        // Вернуть только те пары, сумма которых делится на 3
        List<List<Integer>> pairsBy3 =
                numbers1.stream()
                        .flatMap(number1 -> numbers2.stream()
                                .filter(number2 -> (number1 + number2) % 3 == 0)
                                .map(number2 -> Arrays.asList(number1, number2))
                        )
                        .collect(Collectors.toList());
        System.out.println("pairsBy3 = " + pairsBy3);

    }
}
