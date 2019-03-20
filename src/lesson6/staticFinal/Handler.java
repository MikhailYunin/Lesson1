package lesson6.staticFinal;

public interface Handler {
    public void read();
    public void write();

    public static Handler getInstance(String fileName) {
        /// статик - обращение к методу по имени класса, а не через объект
        Handler handler = null;
        if (fileName.endsWith(".xml")){
            handler = new XMLHandler();
        } else if (fileName.endsWith(".json")){
            handler = new JSONHandler();
        } return handler;
    }

}

class XMLHandler implements Handler{
    @Override
    public void read() {
        System.out.println("Read");
    }

    @Override
    public void write() {
        System.out.println("Write XML");

    }
}

class JSONHandler implements Handler{
    @Override
    public void read() {
        System.out.println("Read JSON");
    }

    @Override
    public void write() {
        System.out.println("Read JSON");

    }
}
