package lesson13;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionExample {
    //рефлексия в java
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        System.out.println(String.class);
        System.out.println(int.class);

        SomeClass someClass = new SomeClass();
        System.out.println(someClass.getClass());

        Class cls = someClass.getClass();
        System.out.println(cls.getName());

        cls = cls.getSuperclass();
        System.out.println(cls.getName());

        // доступ к компонентам класса

        Class<SomeClass> someCls = SomeClass.class;

        // доступ к полям класса

        Field[] fields = someCls.getFields(); // возвращает свои поля и родительские
        System.out.println(Arrays.toString(fields));

        Field[] declaredField = someCls.getDeclaredFields(); // возвращает все поля данного класса
        System.out.println(Arrays.toString(declaredField));

        // доступ к методам

        Method [] methods = someCls.getMethods();
        System.out.println(Arrays.toString(methods));

        Method [] delcaredMethods = someCls.getDeclaredMethods();
        System.out.println(Arrays.toString(delcaredMethods));

        // доступ к конструкторам

        Constructor<?>[] decladerContructor= someCls.getDeclaredConstructors();
        System.out.println(Arrays.toString(decladerContructor));

        // доступ к конкретному полю, методу, конструктору

        Field field = someCls.getDeclaredField("version");
        field.setAccessible(true);
        field.set(someClass, 1);// задает значение поля

        System.out.println(someClass);

        //доступ е приватному методу
        Method method = someCls.getDeclaredMethod("getInfo");
        method.setAccessible(true);
        String data = (String) method.invoke(someClass);
        System.out.println("data: "+data);


        //констуркторы
        Constructor<SomeClass> someClassConstructor = someCls.getDeclaredConstructor(String.class, int.class);
        SomeClass someClass1 = someClassConstructor.newInstance("someClass", 3);
        System.out.println(someClass1);


        //
        boolean isPrivate = Modifier.isPrivate(field.getModifiers());
        boolean isFinal = Modifier.isFinal(field.getModifiers());


        someClass.toString(someClass1);




    }

}

class ParrentClass{
    public void parrentVoid(){
        System.out.println("parrent void");


    }
}

class SomeClass extends ParrentClass {
    private String name;
    int version;

    public SomeClass(String name) {
        this.name = name;
    }

    public SomeClass() {
    }

    public SomeClass(String name, int version) {
        this.name = name;
        this.version = version;
    }

    private String getName() {
        return name;
    }

    private String getInfo(){
        return "private void";
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }

    public static void toString(SomeClass someClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<SomeClass> someCls = SomeClass.class;
        Method method = someCls.getDeclaredMethod("getName");
        method.setAccessible(true);
        String name = (String) method.invoke(someClass);
        Method method2 = someCls.getDeclaredMethod("getVersion");
        method.setAccessible(true);
        int version = (int) method2.invoke(someClass);
        System.out.println("вызов toString из static: SomeClass{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}');

    }

}