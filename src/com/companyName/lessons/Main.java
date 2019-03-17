package com.companyName.lessons;

public class Main {
    public static void main(String[] args) {
        // тип_данных  имя_объекта = new создание_объекта (или вызов конструктора)
        // все пользовательские объекты создаются в куче (heap)
        Book book1 = new Book();
        System.out.println(book1);
        //обращение к свойству
        // book1.pageCount;
        // чтобы задать свойства объекту
        // имя_объекта.имяСвойства
//        book1.pageCount = 34;
        book1.setPageCount(34);
        book1.setTitle(("Азбука"));
//        book1.title = "Азбука";
//        System.out.println(book1.title);//вывод параметра
        System.out.println(book1);// вывод класса

        Book book2 = new Book();
//        book2.pageCount = 122;
//        book2.title = "Сказки";
        book1.setPageCount(34);
        book1.setTitle(("Сказки"));
        System.out.println(book2);

        Book book3 = new Book(39);
        System.out.println(book3);

        Book book4 = new Book(223, "Story");

        int book4PageCount = book4.getPageCount();

        System.out.println("Количество страниц = " + book4.getPageCount());


        Author author = new Author("Иван", "Петров"); // свойства не принадлежат ни кому
        book4.setAuthor(author); // а теперь принадлежит))

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        System.out.println(library);
        System.out.println(library.getBooks("Сказки"));




    }
}
