package part_1_basics.chapter_3_lambdas;

import part_1_basics.chapter_3_lambdas.model.Apple;
import part_1_basics.chapter_3_lambdas.model.Fruit;
import part_1_basics.chapter_3_lambdas.model.Orange;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorMethodReferenceExample {

    static Map<String, Function<Integer, Fruit>> fruitMap = new HashMap<>();

    static {
        fruitMap.put("apple", Apple::new);
        fruitMap.put("orange", Orange::new);
    }

    // Принимает название фрукта и его вес. По названию фрукта извлекает из мапы функцию для его создания.
    // Функция = ссылка на конструктор. Вызывается конструктор, принимающий в качестве параметра вес фрукта.
    public static Fruit giveMeFruit(String fruit, Integer weight) {
        return fruitMap.get(fruit.toLowerCase())
                .apply(weight);
    }

    public static void main(String[] args) {
        // Ссылка на конструктор без параметров
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();

        // Ссылка на конструктор с параметром weight
        Function<Integer, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(100);
        System.out.println("a2 = " + a2);

        // Передача весов, вызов конструктора с весом
        List<Integer> weights = Arrays.asList(5, 23, 7, 12);
        List<Apple> apples = mapWeightsToApples(weights, Apple::new);
        System.out.println("apples = " + apples);

        // Создание разных фруктов
        Fruit orange = giveMeFruit("orange", 200);
        System.out.println("orange = " + orange);
        Fruit apple = giveMeFruit("apple", 150);
        System.out.println("apple = " + apple);
//        Fruit blablabla = giveMeFruit("blablabla", 200);
//        System.out.println("blablabla = " + blablabla);
    }

    public static List<Apple> mapWeightsToApples(List<Integer> weights, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer weight : weights) {
            Apple nextApple = f.apply(weight);
            result.add(nextApple);
        }
        return result;
    }
}
