package lesson4.animals;

public class Cat extends Animal implements Run{

    //реализация метода интерфейса
    @Override
    public void run(){
        System.out.println("Run");
    }


}
