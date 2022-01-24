package part_1_basics.chapter_5_working_with_streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileLinesExample {
    public static void main(String[] args) {
        long uniqueWords = 0;
        // Файл data.txt должен лежать в корне проекта, то есть на уровне файла pom.xml
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
//                    .forEach(System.out::println);
                    .count();
        } catch (IOException ex) {
            // Обработка исключения
            ex.printStackTrace();
        }
        System.out.println("uniqueWords = " + uniqueWords);
    }
}
