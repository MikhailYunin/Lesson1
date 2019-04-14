package fitness;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class FitnessLogger {


    public static void writeToFile(Human human, String type) throws IOException {

        try (FileOutputStream outputStream = new FileOutputStream("src/fitness/file.txt", true))
        {
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            StringBuilder sb = new StringBuilder();
            sb.append(human.getSurname()).append(" ")
                    .append(human.getName()).append(" ")
                    .append(type).append(" ")
                    .append(date.format(formatter))
                    .append("\n");

            byte[] bytes = sb.toString().getBytes(Charset.forName("UTF-8"));
            outputStream.write(bytes);
        }
    }

}
