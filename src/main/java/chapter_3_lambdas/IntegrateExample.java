package chapter_3_lambdas;

import java.util.function.DoubleUnaryOperator;

public class IntegrateExample {
    public static void main(String[] args) {
        // Задача - найти площадь под графиком функции [f(x) = x + 10] от точки x1 = 3 до точки x2 = 7;
        // То есть вычислить интеграл.
        double area = integrate(x -> x + 10, 3, 7);
        System.out.println("area = " + area);
    }

    public static double integrate(DoubleUnaryOperator function, double a, double b) {
        return (function.applyAsDouble(a) + function.applyAsDouble(b)) * (b - a) / 2.0;
    }
}
