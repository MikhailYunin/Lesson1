package dataTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class DataTimeExample {
    public static void main(String[] args) {
        // класс Date() // устаревший
        Date date = new Date();
        Date other = new Date();
        date.after(other); // дата позднее, тру или фолс
        date.before(other); //boolean
        date.compareTo(other); // int -1, 0, 1
        System.out.println(date);

        SimpleDateFormat dateFormat = new SimpleDateFormat("День: dd, Месяц: MM, Год:yyyy HH:mm");
        System.out.println(dateFormat.format(date));
        Calendar calendar = new GregorianCalendar();
        Calendar calendar1 = new GregorianCalendar(2019, Calendar.APRIL, 12);
        //Увеличить дату
        calendar1.add(Calendar.DAY_OF_MONTH, 2);
        // Уменьшить дату
        calendar1.add(Calendar.MONTH, -3);

        System.out.println(calendar1.get(Calendar.MONTH));
        System.out.println(calendar1.getTime());


        //Java 8 Date Time API

//        LocalDate, LocalTime, LocalDateTime, Period, Duration
        System.out.println("//Java 8 Date Time API");
        System.out.println("LocalDate");

        LocalDate dateNow = LocalDate.now();
        System.out.println(dateNow);

//        LocalDate someDate = LocalDate.of(2019, Month.APRIL,22);
//        System.out.println(someDate);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String strDate = "14/04/2018";

        LocalDate parseDate = LocalDate.parse(strDate,dateTimeFormatter);
        System.out.println(parseDate);

        LocalDate tomorrow = dateNow.plusDays(1);// добавление для , месяца и пр.


        System.out.println(LocalDate.now().minusDays(45));

        System.out.println(LocalDate.now().minus(2, ChronoUnit.DAYS)); // почитать про хроноюнитс

        DayOfWeek dayOfWeek = LocalDate.parse("2018-07-12").getDayOfWeek(); // возвращает день недели
        System.out.println(dayOfWeek);


        // LocalTime
        LocalTime timeNow = LocalTime.now();
        System.out.println(timeNow);

        LocalTime setTime = LocalTime.of(6, 39);
        System.out.println(setTime);

        LocalTime setTime2 = LocalTime.parse("12:10");
        System.out.println(setTime2);

        System.out.println(timeNow.plusSeconds(78));
        System.out.println(timeNow.plusMinutes(78));
        System.out.println(timeNow.plusHours(78));

        System.out.println(timeNow.plus(23,ChronoUnit.SECONDS));

        int hours = LocalTime.parse("04:45").getMinute();


        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        System.out.println(localDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE));

        LocalDate startDate = LocalDate.parse("2016-04-12");
        LocalDate finaleDate = startDate.plus(Period.ofDays(67));// разница только в числах месяца

        int between = Period.between(finaleDate,startDate).getDays();

        // Duration

        // дописать
        //
        //
        //

        LocalTime localTime = LocalTime.of (7,23);

    }
}
