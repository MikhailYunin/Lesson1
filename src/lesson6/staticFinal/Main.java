package lesson6.staticFinal;

public class Main {
    public static void main(String[] args) {
        String fileName = "file.txt.json";


        // вызов статического метода
        Handler handler = Handler.getInstance(fileName);
        handler.read();

      //  CalcUtils calcUtils = new CalcUtils();
       // calcUtils.sum(3,5);

        System.out.println(CalcUtils.sum(2,7));

    }
}
