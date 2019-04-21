package fitness;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class FitnessLogger {


    public static void writeToFile(Human human, String type) throws IOException {

        try (FileOutputStream outputStream = new FileOutputStream("src/fitness/file.txt.txt", true))
        {
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("kk.mm");
            StringBuilder sb = new StringBuilder();
            sb.append(human.getSurname()).append(" ")
                    .append(human.getName()).append(" ")
                    .append(type).append(" ")
                    .append(date.format(formatter)).append(" ")
                    .append(time.format(formatter2))
                    .append("\n");


            byte[] bytes = sb.toString().getBytes(Charset.forName("UTF-8"));
            outputStream.write(bytes);
        }



    }

    public static void writeNoAccess(Human human, FitnessServiceEnumiration type) throws IOException {

        try (FileOutputStream outputStream = new FileOutputStream("src/fitness/file.txt.txt", true))
        {
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("kk:mm");
            StringBuilder sb = new StringBuilder();
            sb.append("Отказ в доступе в   " + type + ":   ")

                    .append(human.getSurname()).append(" ")
                    .append(human.getName()).append(" ")
                    .append(date.format(formatter)).append(" ")
                    .append(time.format(formatter2))
                    .append("\n");


            byte[] bytes = sb.toString().getBytes(Charset.forName("UTF-8"));
            outputStream.write(bytes);
        }



    }
}
