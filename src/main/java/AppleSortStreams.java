import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class AppleSortStreams {
    public static void main(String[] args) {
        // Creating apples
        List<Apple> appleList = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            Apple apple = new Apple(i, (int) (Math.random()*230 + 1));
            if (i % 2 == 0) apple.setColor("green");
            appleList.add(apple);
        }

        // Sequential processing
        System.out.println("Sequential processing");
        long start = System.currentTimeMillis();
        List<Apple> heavyApples =
                appleList.stream().filter((Apple a) -> a.getWeight() > 220)
                                  .collect(toList());
        long finish = System.currentTimeMillis();
        System.out.println("It takes, ms: " + (finish - start));
        for (Apple apple : heavyApples) System.out.println(apple);

        // Parallel processing
        System.out.println("Parallel processing");
        start = System.currentTimeMillis();
        List<Apple> heavyApplesParallel =
                appleList.parallelStream().filter((Apple a) -> a.getWeight() > 220)
                                          .collect(toList());
        finish = System.currentTimeMillis();
        System.out.println("It takes, ms: " + (finish - start));
        for (Apple apple : heavyApplesParallel) System.out.println(apple);

    }
}
