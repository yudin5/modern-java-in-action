package part_1_basics.chapter_3;

import java.security.PrivilegedAction;
import java.util.concurrent.Callable;

public class PrivilegedActionAndCallable {
    public static void main(String[] args) throws Exception {

        PrivilegedAction<Integer> integerPrivilegedAction = () -> 42;
        Integer integer = integerPrivilegedAction.run();
        System.out.println("integer = " + integer);

        Callable<Integer> integerCallable = () -> 42;
        Integer integerCall = integerCallable.call();
        System.out.println("integerCall = " + integerCall);
    }
}
