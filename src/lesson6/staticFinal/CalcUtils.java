package lesson6.staticFinal;

public class CalcUtils {



    //статичкескеи переменные
    //final - нельзя переприсвоить
    static final double PI;// = 3.14; //применима к целому классу

    //статические блоки
    static {
        PI=3.14;
    }

    //статический метод
    public static double sum(int a, int b){
        return a+b;
    }

    //final методы нельзя переопределить в дочерних классах
    public final void someVoid(){final int a} // final int a - только для чтения доступны в методе

}


//class Геш extends CalcUtils{
//    @Override
//    public final void someVoid(){}

/}
