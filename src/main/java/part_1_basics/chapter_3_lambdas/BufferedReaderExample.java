package part_1_basics.chapter_3_lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {

    public static void main(String[] args) throws IOException {
        String result = processFile((BufferedReader br) -> br.readLine() + ", " + br.readLine());
        System.out.println("result = " + result);
    }

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return processor.process(br);
        }
    }
}

