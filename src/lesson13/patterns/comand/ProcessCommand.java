package lesson13.patterns.comand;

public class ProcessCommand extends Command{
    @Override
    String name() {
        return "ProcessCommand";
    }

    public ProcessCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    boolean execute() {
        // добавление данных
        System.out.println("execute ProcessCommand");
        return true;
    }
}
