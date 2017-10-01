package homeWork.homeWork11_2.src.main.java;

/**
 * Created by bardakov_vs on 27.09.2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool(3, 10);
        for (int i = 0; i < 51; i++) {
            final int num = i;
            final int threadsNumber = threadPool.getThreadsNumber();
            ///////////////////////////////
            try {
                Thread.currentThread().sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ///////////////////////////////
            Runnable runnable = new Runnable() {
                public void run() {
                    System.err.println("Задание №" + num + " выполняется в потоке: " + Thread.currentThread().getName() +
                            " всего потоков: " + threadsNumber);
                }
            };
            threadPool.execute(runnable);
        }


        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.interruptAll();
    }
}
