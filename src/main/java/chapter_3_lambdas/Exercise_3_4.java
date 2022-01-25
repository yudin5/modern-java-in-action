package chapter_3_lambdas;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.*;

public class Exercise_3_4 {
    public static void main(String[] args) {

        Function<String, Double> function = string -> (double) string.getBytes(StandardCharsets.UTF_8).length;
        System.out.println("function = " + function.apply("test"));

        IntBinaryOperator intBinaryOperator = (x, y) -> Math.max(x, y) + 5;
        System.out.println("intBinaryOperator.applyAsInt(2, 3) = " + intBinaryOperator.applyAsInt(2, 3));

        LongConsumer longConsumer = l -> {
            Date date = new Date(l);
            System.out.println("date = " + date);
        };
        longConsumer.accept(100500L);

        BooleanSupplier booleanSupplier = () -> Math.random() > 0.5;
        boolean randomBoolean = booleanSupplier.getAsBoolean();
        System.out.println("randomBoolean = " + randomBoolean);

        BiFunction<Integer, Long, Date> biFunction = (i, l) -> new Date(i + l);
        System.out.println("biFunction = " + biFunction.apply(100500, 100500L));
    }
}
