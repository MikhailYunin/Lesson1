package lesson4.animals;

public interface Eat {

    default public void stop(){
        System.out.println("Stop");
    }

    public void eat(Animal animal);


}
