package multiTreading.synhronize;

import homework.MapHomework;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Top100 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // выполнить подсчет топ 100 слов параллельно

        //количество потоков должно быть равно числу доступных процессоров системы

        ClassLoader loader = MapHomework.class.getClassLoader();
        File file = new File(loader.getResource("file.txt").getFile());
        List<String> lines = Files.readAllLines(file.toPath());

        List<String> words = new ArrayList<>();

        for (String line: lines){
            String[] wordSplit = line.toLowerCase() // приведение к нижнему регистру
                    .replaceAll("\\p{Punct}", " ") // знаки препинания на пробел
                    .trim() // убираем пробелы
                    .split("\\s");
            for (String s: wordSplit){
                if (s.length() > 0) {
                    words.add(s.trim());
                }
            }
        }

        int numProc =Runtime.getRuntime().availableProcessors();

        int num = words.size()/numProc; // количество слов на один процессор
        int ost = words.size()%numProc; // остаток от деления
        List<String> words1 = new ArrayList<>();
        List<String> words2 = new ArrayList<>();
        List<String> words3 = new ArrayList<>();
        List<String> words4 = new ArrayList<>();
        words1 = words.subList(1,num);
        words2= words.subList(num,num*2);
        words3= words.subList(num*2,num*3);
        words4= words.subList(num*3,num*4+ost); // четверть + остаток слов

        HashMap<String, Integer> map = new HashMap<>();
        Thread myThread1 = new MyThread(words1, map);
        Thread myThread2 = new MyThread(words2, map);
        Thread myThread3 = new MyThread(words3, map);
        Thread myThread4 = new MyThread(words4, map);
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();

        myThread1.join();
        myThread2.join();
        myThread3.join();
        myThread4.join();





        // Вывести топ 10 самых частых слов и фраз.
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return  Integer.compare(o2.getValue(), o1.getValue());
            }
        });

        System.out.println(entries.subList(0,100).toString());


    }
}


class MyThread extends Thread {

    List<String> words;
    List<Map.Entry<String, Integer>> top;
    HashMap<String, Integer> wordMap;

    public MyThread(List<String> words, HashMap<String, Integer> wordMap ) {
        this.words = words;
        this.wordMap = wordMap;
    }

    public List<Map.Entry<String, Integer>> getTop() {
        return top;
    }

    @Override
    public void run() {

        //Сосчитать частоту встречаемости слов в War and peace (файл wp.txt).

        for (String word: words) {
            if (wordMap.containsKey(word)){
                synchronized (wordMap) {
                    wordMap.put(word, wordMap.get(word) + 1);
                }
            } else {
                synchronized (wordMap) {
                    wordMap.put(word, 1);
                }
            }
        }






    }





}