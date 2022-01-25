package chapter_3_lambdas;

import chapter_3_lambdas.model.Apple;

import java.util.function.Function;

public class FunctionComposition {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(1);
        System.out.println("result 1 = " + result);

        Function<Integer, Integer> h2 = f.compose(g);
        result = h2.apply(1);
        System.out.println("result 2 = " + result);

        Function<Apple, String> beforeToString = apple -> "Яблочко! \n" + apple.toString();
        Function<Apple, String> customToString = beforeToString
                .andThen(String::toUpperCase)
                .andThen(String::toLowerCase)
                .andThen(s -> s.replace("a", "A-a-a"))
                .andThen(s -> s.substring(0, 34));
        String customToStringApple = customToString.apply(new Apple(100));
        System.out.println("customToStringApple = " + customToStringApple);
    }
}
