package lesson13.patterns.comand;

public class ExitCommand extends Command{
    @Override
    String name() {
        return null;
    }

    public ExitCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    boolean execute() {
        // реализовать выход из программы
        System.out.println("execute ExitCommand");
        return false;
    }
}
