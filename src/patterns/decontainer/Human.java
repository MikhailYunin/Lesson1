package patterns.decontainer;

import patterns.decontainer.di.AutoField;
import patterns.decontainer.di.AutoRun;
import patterns.decontainer.di.Component;

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
