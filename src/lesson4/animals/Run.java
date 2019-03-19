package lesson4.animals;

public interface Run{

    default public void stop(){
        System.out.println("Stop");
    }


    public void run();


}
