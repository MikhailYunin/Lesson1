package lesson6.object;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Object object = new Object();

        Autor autor = new Autor("Autor");
        Message message = new Message();
        message.setAutor(autor);
        message.setMessageText("message text");


        //tostring-строковое представление объекта
        System.out.println(message.toString());


        //hashCode() - возвращает хеш код объекта.
        // Хеш код - исходный адрес в памяти в шестнадцатиричной системе исчисления;
        //
        System.out.println(autor.hashCode());
        System.out.println(message.hashCode());

        //-XX:hashCode=2 для выбора реализации hashCode
        //--XX:+UnlockExperementalVMOptions - включение эксперементальных опций

        //equals(Object o) метод для сравнения объектов
        Message message1 = new Message();
        message1.setAutor(autor);
        message1.setMessageText("text");

        Message message2 = new Message();
        message2.setAutor(autor);
        message2.setMessageText("text");


        System.out.println("сравнение объектов м1 и м2"+message1.equals((message2))); // false

        System.out.println(message1.hashCode());
        System.out.println(message2.hashCode());


        //метод clone() позволяет создать копию объекта

        Message message3 = (Message) message1.clone(); // к месаджу добавить implements Cloneable

    }
}
