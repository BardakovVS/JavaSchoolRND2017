package homeWork.homeWork11_2.src.main.java;
/**
 * Created by bardakov_vs on 27.09.2017.
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final ThreadPool threadPool = new ThreadPool(3, 10);
        for (int i = 0; i < 30; i++) {
            final int num = i;
            ///////////////////////////////
            try {
                Thread.currentThread().sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ///////////////////////////////
            Runnable runnable = new Runnable() {
                public void run() {
                    System.err.println("Задание_1 №" + num + " выполняется в потоке: " + Thread.currentThread().getName() +
                            " всего потоков: " + threadPool.getThreadsNumber());
                }
            };
            threadPool.execute(runnable);
        }
        ///////////////////////////////
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ///////////////////////////////
        for (int i = 0; i < 30; i++) {
            final int num = i;
            ///////////////////////////////
            try {
                Thread.currentThread().sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ///////////////////////////////
            Runnable runnable = new Runnable() {
                public void run() {
                    System.err.println("Задание_2 №" + num + " выполняется в потоке: " + Thread.currentThread().getName() +
                            " всего потоков: " + threadPool.getThreadsNumber());
                }
            };
            threadPool.execute(runnable);
        }
        try {
            Thread.currentThread().sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.interruptAll();
    }
}
