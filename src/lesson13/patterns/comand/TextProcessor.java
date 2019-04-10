package lesson13.patterns.comand;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TextProcessor {

    public static void main(String[] args) {
        TextProcessor textProcessor = new TextProcessor();
        textProcessor.start();

    }
    private CommandHistory history = new CommandHistory();

    public void executeComand (Command command){
        if (command.execute()){
            history.add(command);
        }

    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            switch (scanner.nextLine()){
                // проверить фабричный метод
                case "process":
                    executeComand(new ProcessCommand(this));
                    break;
                case "exit":
                    executeComand(new ExitCommand(this));
                    break;

                    /// дописать еще команды
                // занесение данных в хранилище
            }
        }
    }
}

class CommandHistory {
    private Stack<Command> history = new Stack<>();

    public void add(Command command){
        history.push(command);
    }

    public Command delete(){
        return history.pop();
    }

    public boolean isEmpty(){
        return history.isEmpty();
    }
}