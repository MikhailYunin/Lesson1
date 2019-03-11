package Lesson2;

import java.util.Locale;
import java.util.Scanner;

public class ConstrukciiVetvlenia {
    public static void main(String[] args) {
        System.out.println("Вывод из консоли");
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);// воспринимает точку
        System.out.println("Введите код");
        int code = in.nextInt();
//новый код
        int a=5;
        int b=7;
        if (b==5){
            System.out.println("Совпадение А=5");
            if (b==7) {
                System.out.println("Совпадение b=7");
            }
        } else if (b==7)
            System.out.println("Совпадение b=7");
        ///ghbkjsdkjsdkjdkjs
        if (code == 123 ) {
            System.out.println("Вы вошли как администратор");
        } else if (code == 345) {
            System.out.println("Вы вошли как пользователь");
        }
        else {
            System.out.println("Вы не вошли");
        }


        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите код");
        int num = in2.nextInt();

        String res;

        switch (num){
            case 333333:
                res = "Большой приз";
                break; //выход из switch в случае успеха
            case 333334:
            case 333335:
                res = "Средний приз";
                break;
            case 333339:
            case 333337:
                res = "Малый приз";
                break;
            default:
                    res = "Нет приза";




        }
        System.out.println("Нет приза");


        //циклы

        int messageCount = 5;
        while (messageCount > 0) {
            System.out.println("Сообщение "+messageCount);
            messageCount--;

        }

        //проверка условия после выполнения кода
        do {
            System.out.println("Первая итерация");
        } while (false);

//        for (инициализация; проверка условия; шаг){
//            ТЕЛО ЦИКЛА
//        }

        for (int i=1; i<11; i++) {
            System.out.println("i = "+i);
        }

        for (int i=1; i<11; i++) {
            if (i % 2 == 0) continue; // переход к следующему шагу итерации
            System.out.println("i = "+i);
        }

        for (int i = 0; i < 3; i++){
            System.out.println("Внешний цикла "+i);
            for (int j = 0; j < 15; j++){
                System.out.println("j= "+j);
                if (j == 5) break; // выход из цикла
            }
        }

        outer: for (int i = 0; i <3; i++) {
            System.out.println("Внешний цикла");
            for (int j = 0; j < 15; j++){
                System.out.println("j= "+j);
                if (j == 5) break outer; // выход из цикла с меткой
            }
        }

    }
}
