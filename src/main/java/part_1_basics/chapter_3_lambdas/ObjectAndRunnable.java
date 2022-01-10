package part_1_basics.chapter_3_lambdas;

public class ObjectAndRunnable {
    public static void main(String[] args) {
//        Object o = () -> System.out.println("Tricky!"); // Не компилируется
        Object o = (Runnable) () -> System.out.println("Tricky!");
        System.out.println("o = " + o);
        Runnable r = () -> System.out.println("Tricky!");
        System.out.println("r = " + r);
        r.run();

        Integer portNumber = 3313;
        Runnable runnable = () -> System.out.println(portNumber);
        runnable.run();
//        portNumber = 234; // Не скомпилируется
    }
}
