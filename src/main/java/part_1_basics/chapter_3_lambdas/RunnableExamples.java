package part_1_basics.chapter_3_lambdas;

public class RunnableExamples {
    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Hello world 1");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world 2");
            }
        };
        process(r1);
        process(r2);
        process(() -> System.out.println("Hello world 3"));

        process(() -> {
            int i = 4;
            System.out.println("Hello world " + i);
            i = 5;
            System.out.println("Hello world " + i);
        });

    }

    public static void process(Runnable r) {
        r.run();
    }
}
