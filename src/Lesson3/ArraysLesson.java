package Lesson3;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {
//        java.util.Arrays
         // объявление переменной для массива
        int [] arr; // предпочтительный
        int arr2[];
        // создать масив
        arr = new int[5];
        System.out.println(Arrays.toString(arr));

        char[] chars = new char[3];
        System.out.println(Arrays.toString(chars));

        //null
        //размер массива изменить нельзя
        int arrLenght = arr.length;
        System.out.println("Размер массива arr: "+arrLenght);

        int[] arr3 = {2,4,6,1,89};
        arr3=new int[]{2,6};

        //обращение к элементам массива
//        System.out.println(arr3[1]);
//        int[] arr4 = new int[4];
//        for (int i=0; i<arrLenght; i++) arr4[i] += 4;
//        System.out.println(Arrays.toString(arr4));


        // копирование массива
        int[] arr5 = {2,7,1,90};
//        int[] arr6 = arr5 // невозможно так скопировать

        int[] arr6 = arr5.clone();

        int[] arr7 = new int[10];
        System.arraycopy(arr5, 1, arr7, 2,2);
        System.out.println(Arrays.toString(arr7));

        int[] arr8 = {2,7,1,90};
        int[] copyArr = Arrays.copyOf(arr8,12);
        System.out.println(Arrays.toString(copyArr));

        // перебор массива

        for (int i=0; i<arr8.length; i++) {
            System.out.println(arr8[i]);
            arr8[i] += 3;
        }
        System.out.println(Arrays.toString(arr8));

        //только перебор, без изменения элементов массива
        for (int num: arr8) {
            System.out.println(num);
            num += 3;
        }
        System.out.println(Arrays.toString(arr8));

        // сравнение массивов

        int[] arr9 = new int[5];
        int[] arr10 = new int[5];
//        так нельзя сравнивать:
//        System.out.println(arr9 == arr10);
//        System.out.println(arr9.equals(arr10));
        System.out.println(Arrays.equals(arr9, arr10));

        Arrays.fill(arr9,23); // наполнение массива

        //поиск в массиве

        int[] arr11 = {2,4,6,1,89};
        System.out.println(Arrays.binarySearch(arr11,4));

        //содержит ли массив указанный элемент
        String[] strArr = {"qwe", "asd", "zxc"};
        System.out.println(Arrays.asList(strArr).contains("qwe"));

        //сортировка массива
        // быстрая сортировка и метод бинарного поиска, выбор опорного элемента, просмотреть дома

        Arrays.sort(arr11);
        System.out.println(Arrays.toString(arr11));


    }
}
