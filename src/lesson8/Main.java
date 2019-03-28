package lesson8;

public class Main {
    public static void main(String[] args) {
        Book tails = new Book("tails", 34);
        Book flowers = new Book("flowers", 56);

        Car car = new Car ("red");

//        LinkedList bookStorage = new LinkedList();
//        bookStorage.add(tails);
//        bookStorage.add(flowers);
//
//        bookStorage.add(car);
//
////        Book bookFromStorage1 = (Book)  bookStorage.get(0);
//        System.out.println(bookFromStorage1.getTitle());
//
//        Book bookFromStorage2 = (Book)  bookStorage.get(0);
//        System.out.println(bookFromStorage2.getTitle());


        LinkedList<Book> bookStorage = new LinkedList<>();
        bookStorage.add(tails);
        bookStorage.add(flowers);


      //  bookStorage.add(car);

        LinkedList<Car> carStorage = new LinkedList<>();
        carStorage.add(car);

        Book bookFromeStorage3 = bookStorage.get(0);
        System.out.println(bookFromeStorage3.getTitle());

        Car carFromeStorage3 = carStorage.get(0);
        System.out.println(carFromeStorage3.color);

        LinkedList<ChildBook> childBookStorage = new LinkedList<>();
        ChildBook coloring = new ChildBook("coloring", 23);
        childBookStorage.add(coloring);

        Book book=getFirstBook(childBookStorage);





    }
    // со всеми потомками
    public static Book getFirstBook(LinkedList<? extends Book> storage){

//        ChildBook book = new ChildBook("book",12);
//        storage.add(book);

        return storage.get(0);
    }


    // класс Book и все его предки
    public  void addToStorage(LinkedList <? super Book> storage){
        Book book = new Book("Book",234);
        storage.add(book);

//        Book book1 = storage.get(0);
        Object o = storage.get(0);
        System.out.println(o);

    }

    //перегружать методы generic Нельзя
    public void someVoid(LinkedList<String> storage){}
//    public void someVoid(LinkedList<Integer> storage){}

//    public static Т staticVoid(){}

    public static void storage(LinkedList<?> storage){
        Book book = new Book("Book",123);
//        storage.add(book);
        storage.add(null);

//        Book book1 = storage.get(0);
//        Object o = storage.get(0);


    }
}
