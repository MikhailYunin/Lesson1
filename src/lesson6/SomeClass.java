package lesson6;

public class SomeClass {

    private SomeClass(){};

    private static final SomeClass obj = new SomeClass();

//    static SomeClass getObj(){
//        return new SomeClass();
//    }

    static  SomeClass getObj(){
        return obj;
    }


    public void printInfo(String string){
        System.out.println("info"+string);
    }


}

class SomeClass2 {
    public void someVoid(){

        SomeClass someClass = SomeClass.getObj(); // new SomeClass
        SomeClass someClass2 = SomeClass.getObj(); // new SomeClass
        someClass.printInfo("data");
    }
}
