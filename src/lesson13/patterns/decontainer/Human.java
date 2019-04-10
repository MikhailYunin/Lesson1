package lesson13.patterns.decontainer;

import lesson13.patterns.decontainer.di.AutoField;
import lesson13.patterns.decontainer.di.AutoRun;
import lesson13.patterns.decontainer.di.Component;

@Component
public class Human {
    @AutoField
    Cat cat;
    Dog dog;

    public Human(){
        System.out.println("Human init");
    }

    @AutoRun
    public void walkWithCat(){
        System.out.println("walk with" + cat.getCatName());
    }

}
