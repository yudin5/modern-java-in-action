package part_1_basics.chapter_5_working_with_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapUniqueSymbols {
    public static void main(String[] args) {
        // Задача - получить уникальные символы из потока слов
        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> arrays = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("arrays = " + arrays);

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
        System.out.println("streamOfWords = " + streamOfWords);

        System.out.println("streamOfWords (List) = " + streamOfWords.collect(Collectors.toList()));

        List<Stream<String>> listOfStreams = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("listOfStreams = " + listOfStreams);

        // Решение
        List<String> uniqueCharacters =
                words.stream()
                        .map(word -> word.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println("uniqueCharacters = " + uniqueCharacters);

    }
}
