package lesson9.collect;

import sun.reflect.generics.tree.Tree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class CollectionExample {
    public static void main(String[] args) throws IOException {
//        ArrayList<Book> bookArryList = new ArrayList<>(4);

        //порядок элементов сохранен
        ArrayList<Book> bookArryList = new ArrayList<>();
        bookArryList.add(new Book("Book"));
        bookArryList.add(new Book("Book"));
        bookArryList.add(new Book("Cars"));
        bookArryList.add(2, new Book("Alfabet"));
        System.out.println(bookArryList.size());

        for (Book book: bookArryList){ // перебор
            System.out.println(book.getTitle());
        }

        // порядок элементов может быть не сохранен
        Set<Book> bookSet = new HashSet<>(bookArryList);
        System.out.println("  --bookset--");
        for (Book book: bookSet){ // перебор
            System.out.println(book.getTitle());
        }


        System.out.println("   --bookLinkedList--");
        LinkedList<Book> bookLinkedList = new LinkedList<>();
        bookLinkedList.add(new Book("Book 1"));
        bookLinkedList.add(new Book("Book 2"));
        bookLinkedList.add(new Book("Book 3"));
        for (Book book: bookLinkedList){ // перебор
            System.out.println(book.getTitle());
        }


        System.out.println("   --TreeSet--");
        TreeSet<String> strings = new TreeSet<>();
        strings.add("Hello");
        strings.add("Hi");
        strings.add("ASD");

        for (String str: strings){ // перебор
            System.out.println(str);
        }

        TreeSet<Book> bookTreeSet = new TreeSet<>();
        bookTreeSet.add(new Book("Book 1"));
        bookTreeSet.add(new Book("Book 2"));
        System.out.println(bookTreeSet);


        User user1 = new User("US1",23 );
        User user2 = new User("US2",23 );



        TreeSet<User> users = new TreeSet<>(new UserComparator()); // второй вариант сравнения из собственного метода
        users.add(user1);
        users.add(user2);
        for (User user: users){ // перебор
            System.out.println(user.getName());
        }

        Comparator<User> userComparator = new UserComparator()
                .thenComparing(new UserAgeComporator());

        TreeSet<User> userTreeSet = new TreeSet<>(userComparator);
        userTreeSet.add(new User("wda",34));
        userTreeSet.add(new User("wda",12));
        userTreeSet.add(new User("Tom",34));
        userTreeSet.add(new User("Alex",56));

        for (User user: userTreeSet){ // перебор
            System.out.println(user.getName()+ " - " + user.getAge());
        }

        ClassLoader loader = CollectionExample.class.getClassLoader();
        File file = new File(loader.getResource("file.txt").getFile());

        // читаем строки из файла
        List<String> lines = Files.readAllLines(file.toPath());

        List<String> words = new ArrayList<>();

        for (String line: lines) {
            String[] wordSplip = line.toLowerCase() // приведение к нижнему регистру
                                    .replaceAll("\\p{Punct}", " ")// удаляем знаки препинания
                                    .trim() // убираем пробелы
                                    .split("\\s");
            for (String s: wordSplip){
                if (s.length()>0){
                    words.add(s.trim());
                }

            }
        }
        for (String word: words) {
            System.out.println(word);
        }

    }
}

// для хранения объектов в трисете класс должен расширять интерфейс Comparable
class Book implements Comparable<Book>{
    String title;

    public Book (String title) {
        this.title= title;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getTitle(), book.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }


    // 0-объекты равны
    // отрицательное значение - объект будет стоять до Object o
    // положительное значение - объект будет стоять после Object o
    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.getTitle());
    }
}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }



    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() &&
                Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }


}

class UserComparator implements Comparator<User>{

    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class UserNameComporator implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class UserAgeComporator implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}