package com.companyName.lessons;

public class Book {

// свойства (атрибуты, поля)
    private int pageCount;
    private String title;
    private Author author;


    //конструктор по умолчанию
    public Book() { }


    public Book (int pageCount) {
        this.pageCount = pageCount;
    }

    public Book (Author author) {
        this.author = author;
    }

    public Book (int pageCount, String title) {
        this.pageCount = pageCount;
        this.title = title;
    }




    public int getPageCount() {
        return pageCount;
    }

    public String getTitle() {
        return title;
    }


    public Author getAuthor() { // Autor - тип данных
        return author; // author - объект
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPageCount(int pageCount) {
        if (pageCount<1) {

            //любая проверка входящих данных
            System.out.println("Ошибка в количестве страниц");
            return;// работа метода прекращается
        }
        this.pageCount = pageCount;
        //this - ссылка на текущий объект

    }

    public void setTitle(String title) {
        this.title = title;
    }



    //Альт+инсерт

    //для вывода свойств объекта в консоль
    @Override
    public String toString() {
        return "Book{" +
                "pageCount=" + pageCount +
                ", title='" + title + '\'' +
                '}';
    }

}
