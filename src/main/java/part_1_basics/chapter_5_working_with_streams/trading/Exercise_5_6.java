package part_1_basics.chapter_5_working_with_streams.trading;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise_5_6 {
    public static void main(String[] args) {
        // Предметная область - трейдеры и транзакции, классы Trader и Transaction
        // Создаём список трейдеров
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        // Создаём список транзакций
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Задача 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей)
        List<Transaction> transactions2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("transactions2011 = " + transactions2011);

        // Задача 2. Вывести список неповторяющихся городов, в которых работают трейдеры
        List<String> distinctCities = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinctCities = " + distinctCities);

        // Задача 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам
        List<Trader> tradersCambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct() // обязательно нужно удалить дубликаты
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("tradersCambridge = " + tradersCambridge);

        // Задача 4. Вернуть строку со всеми именами трейдеров, отсортированных в алфавитном порядке
        String distinctNames = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce("", (s1, s2) -> s1 + " " + s2);
        System.out.println("distinctNames = " + distinctNames);

        // Решение через joining(), более экономичное по ресурсам
        String distinctNamesJoining = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(" "));
        System.out.println("distinctNamesJoining = " + distinctNamesJoining);

        // Задача 5. Выяснить, существует ли хоть один трейдер из Милана
        boolean traderFromMilan = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .anyMatch("Milan"::equals);
        System.out.println("traderFromMilan = " + traderFromMilan);

        // Задача 6. Вывести суммы всех транзакций трейдеров из Кембриджа
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // Задача 7. Какова максимальная сумма среди всех транзакций.
        Integer maxValue = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println("maxValue = " + maxValue);

        // Решение через reduce()
        Integer maxValueReduce = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .orElse(0);
        System.out.println("maxValueReduce = " + maxValueReduce);

        // Задача 8. Найти транзакцию с минимальной суммой
        Integer minValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .orElse(0);
        System.out.println("minValue = " + minValue);

        // Вариант без reduce()
        Transaction transactionWithMinValue = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .get();
        System.out.println("transactionWithMinValue = " + transactionWithMinValue);
    }
}
