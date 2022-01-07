package part_1_basics.chapter_3;

import java.util.concurrent.*;

public class CallableExamples {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Callable<String> callString = () -> "Hello!";

        // Сначала объявляем лямбду, потом передаём её в метод
        Callable<String> threadName = () -> Thread.currentThread().getName();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadNameFutureResult = executorService.submit(threadName);
        System.out.println("Имя потока = " + threadNameFutureResult.get());

        // Сразу передаём лямбду
        Future<String> stringFuture = executorService.submit(() -> Thread.currentThread().getName());
        System.out.println("Имя потока = " + stringFuture.get());

        executorService.shutdown();
    }
}
