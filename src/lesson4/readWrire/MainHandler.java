package lesson4.readWrire;

public class MainHandler {
    public static void getHandler (Handler handler){
        handler.read();
    }

    public static void main(String[] args) {
        Handler jsoNhandler = new JSONhandler();
        getHandler(jsoNhandler);
    }

}
