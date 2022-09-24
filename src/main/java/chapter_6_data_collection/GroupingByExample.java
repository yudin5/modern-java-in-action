package chapter_6_data_collection;

import chapter_5_working_with_streams.trading.Trader;
import chapter_5_working_with_streams.trading.Transaction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByExample {
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

        Map<Integer, List<Transaction>> transactionsByYear =
                transactions.stream()
                        .collect(Collectors.groupingBy(Transaction::getYear));
        System.out.println("transactionsByYear = " + transactionsByYear);

        Stream<Trader> traders = Stream.of(raoul, mario, alan, brian);
        Map<String, List<Trader>> tradersByCity = traders.collect(Collectors.groupingBy(Trader::getCity));
        System.out.println("tradersByCity = " + tradersByCity);

        // Сложный пример. Попытка вручную получить мапу из городов и имён трейдеров
        // вида {Milan=[Mario], Cambridge=[Raoul, Alan, Brian]}
        // Выглядит ужасно. Хотя не так уж и ужасно.
        Stream<Trader> traders2 = Stream.of(raoul, mario, alan, brian);
        Map<String, List<String>> traderNamesByCity = new HashMap<>();
        traders2
                .forEach(trader -> {
                    if (traderNamesByCity.containsKey(trader.getCity())) {
                        List<String> names = traderNamesByCity.get(trader.getCity());
                        names.add(trader.getName());
                    } else {
                        List<String> newNamesList = new ArrayList<>(List.of(trader.getName()));
//                        newNamesList.add(trader.getName());
                        traderNamesByCity.put(trader.getCity(), newNamesList);
                    }
                });
        System.out.println("traderNamesByCity = " + traderNamesByCity);

    }
}
