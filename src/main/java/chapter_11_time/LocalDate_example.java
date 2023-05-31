package chapter_11_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDate_example {
    public static void main(String[] args) {

        // Получение даты и её составляющих
        LocalDate date = LocalDate.of(2023, 5, 31);
        int year = date.getYear();
        Month month = date.getMonth();
        int dayOfMonth = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int lengthOfMonth = date.lengthOfMonth();
        boolean leapYear = date.isLeapYear(); // високосный год

        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("dayOfMonth = " + dayOfMonth);
        System.out.println("dayOfWeek = " + dayOfWeek);
        System.out.println("lengthOfMonth = " + lengthOfMonth);
        System.out.println("leapYear = " + leapYear);

        // То же самое через метод get() и TemporalField
        int year2 = date.get(ChronoField.YEAR);
        int month2 = date.get(ChronoField.MONTH_OF_YEAR);
        int dayOfWeek2 = date.get(ChronoField.DAY_OF_WEEK);

        System.out.println("year2 = " + year2);
        System.out.println("month2 = " + month2);
        System.out.println("dayOfWeek2 = " + dayOfWeek2);

        // То же самое через методы вида getMonthValue() - возвращают int, а не Month
        int monthValue = date.getMonthValue();
        int dayOfMonth2 = date.getDayOfMonth();
        int dayOfYear = date.getDayOfYear();

        System.out.println("monthValue = " + monthValue);
        System.out.println("dayOfMonth2 = " + dayOfMonth2);
        System.out.println("dayOfYear = " + dayOfYear);

        // Текущая дата
        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);

    }
}
