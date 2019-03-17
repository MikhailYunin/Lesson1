package Lesson3;

import java.util.Arrays;

public class StringLesson {
    public static void main(String[] args) {
        String string = "Строка";
        String string2 = "Строка"; // создается в пуле строк, и если имеется такая, то добавляется ссылка на имеемую строку
        String string3 = new String("Строка");
        string3 =string3.intern(); // отправка в пул строк
        String string4 = new String("Строка");

        //сравнение строк
        System.out.println(string == string2);
        System.out.println(string == string3);

        // сравнение

        System.out.println(string.equals(string2));

        // сравнение без учета регистра
        System.out.println(string.equalsIgnoreCase(string2));

        System.out.println(string.startsWith("Ст")); // поиск по началу строки
        System.out.println(string.endsWith("а")); // поиск по концу строки

        // сортировка строк

        String[] strArr = {string,string4,string2};
        Arrays.sort(strArr);

        // конкатенация строк

        String string5="Str 1";
        String string6="Str 2";
        String string7=string5+string6;

        String string8="Начало";
        for (int i=0; i<3; i++) {
            string8 += "итерация цикла";// не рекомендуется
        }
        System.out.println(string8);

        //StringBuilder stringBuilder;// быстрее, для однопоточных
        //StringBuffer stringBuffer; // для многопоточных, медленный

        string8 = "Начало";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string8);
        for (int i=0; i<3; i++) {
            stringBuilder.append("итерация цикла")
                    .append(i)
                    .append(" ");

        }
        string8=stringBuilder.toString();
        System.out.println(stringBuilder);

        //методы работы со строками

        string8.substring(2);
        System.out.println(string8.substring(2,7)); // взятие элементов строки

        string.split(""); // разбивает строку на массив строк
        System.out.println(Arrays.toString(string.split("")));

        System.out.println(string8.trim()); // удаление пробелов
        string8.replaceAll("","new str"); //замена символов


    }
}
