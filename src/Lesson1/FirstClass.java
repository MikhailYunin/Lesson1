package Lesson1;

public class FirstClass {
    public static void main(String[] args) {
       System.out.println("Hello world");


//       целые
       byte byteVar;
       int a=1_000_000;
       long longVar=2_000_000_000_000L;

//       с плавающей точкой
        float floatVar = 2.3F;
        double doubleVar = 2.3;

//        логический тип
        boolean isActive = true;
        boolean sterteed = false;

//        автоматическое преобразование
        int j = 200;
        long k = j;

//        приведение типов
        long n= 90;
        int m = (int) n;

//        математические операторы
//        + - * / %

//        инкремент
        int i=3;
        i++;
        ++i;

//        декремент
        i--;
        --i;

//        операторы сравнения
//        < > -- >= <= !=

//        логические операторы
//        && (и)
//        (a && b) (обе истины только)
//        || (или)
//        (a & b) (любая истина
//        !а (не)
//        if (!a)

//        (a ^ b) (одна тру, другая фолс)

//          операторы присваивания
//          = += -= *= /= %=
        a=12;
        a +=3; //a=a+3;

//        Тернарный оператор

/*        переменная а= (условие)? выражение 1(если условие истина): выражение 2(если условие ложное);
                       а<b*/
        int z = 6;
        int x = 8;
        int r = (z < x) ? z * x : z+x;

    }
}
