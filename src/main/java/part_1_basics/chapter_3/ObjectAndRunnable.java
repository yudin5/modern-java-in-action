package part_1_basics.chapter_3;

public class ObjectAndRunnable {
    public static void main(String[] args) {
//        Object o = () -> System.out.println("Tricky!"); // Не компилируется
        Object o = (Runnable) () -> System.out.println("Tricky!");
        System.out.println("o = " + o);
        Runnable r = () -> System.out.println("Tricky!");
        System.out.println("r = " + r);
        r.run();
    }
}
