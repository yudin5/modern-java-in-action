package chapter_3_lambdas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalDateTimeComparator {

    public static void main(String[] args) {

        LocalDateTime date1 = LocalDateTime.now();
        LocalDateTime date2 = date1.plusDays(5);
        LocalDateTime date3 = date1.minusDays(10);

        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
        System.out.println("date3 = " + date3);

        List<LocalDateTime> dates = new ArrayList<>(Arrays.asList(date1, date2, date3));
        System.out.println("before sort = " + dates);
        dates.sort(LocalDateTime::compareTo); // Сортировка от более старого времени к новому
        System.out.println("after sort = " + dates);

    }


}
