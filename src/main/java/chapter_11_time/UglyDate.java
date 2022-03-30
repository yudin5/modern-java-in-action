package chapter_11_time;

import java.util.Date;

public class UglyDate {
    public static void main(String[] args) {

        // Отсчёт лет начинается с 1900, месяцев - с 0
        Date date = new Date(117, 8, 21);
        // Date date = new Date(117, Calendar.SEPTEMBER, 21);
        System.out.println("date = " + date);
    }
}
