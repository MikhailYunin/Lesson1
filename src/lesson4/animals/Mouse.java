package lesson4.animals;

public class Mouse extends Animal implements Run, Eat{

    @Override
    public void run() {

    }

    @Override
    public void eat(Animal animal) {

    }

    @Override
    public void stop() {
        System.out.println("Mouse stop");

    }
}
