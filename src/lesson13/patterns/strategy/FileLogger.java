package lesson13.patterns.strategy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ILogger {
    @Override
    public void write(String info) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true)))
        {
            writer.write("log info: " + info);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
