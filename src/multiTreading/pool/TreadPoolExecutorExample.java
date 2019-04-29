package multiTreading.pool;

import java.util.concurrent.*;

public class TreadPoolExecutorExample {



    public static void main(String[] args) {

        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ExecutorService pool = new ThreadPoolExecutor(
                1, // основное количество потоков
                10, // максимальное количество потоков
                2, TimeUnit.MINUTES, //как долго могут потоки простаивать
                new ArrayBlockingQueue<>(3) // очередб для задач, которую будут выполнять эти потоки
        );

        queue.add(new Task());
        queue.add(new Task2());
        queue.add(new Task2());
        queue.add(new Task());
        queue.add(new Task2());
        queue.add(new Task());
        queue.add(new Task3());

        for (Runnable runnable: queue) {
            pool.execute(runnable);
        }

        pool.shutdown();
    }

}

class Task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task: "+ Thread.currentThread().getName());
    }
}



class Task2 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task2: "+ Thread.currentThread().getName());
    }
}


class Task3 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task3: "+ Thread.currentThread().getName());
    }
}

