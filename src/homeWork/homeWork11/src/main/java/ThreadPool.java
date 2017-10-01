package homeWork.homeWork11.src.main.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bardakov_vs on 27.09.2017.
 */
public class ThreadPool implements ThreadPoolInterface {
    private Queue<Runnable> worksQueue = new LinkedList<Runnable>();
    private Thread[] threads;
    private boolean appStop = false;

    public ThreadPool(int threadsNumber) {
        start(threadsNumber);
    }

    public void start(int threadsNumber) {
        if (threadsNumber > 0) {
            threads = new Thread[threadsNumber];
            for (int i = 0; i < threadsNumber; i++) {
                threads[i] = new Worker();
                //threads[i].setDaemon(true);
                threads[i].start();
            }
        } else {
            throw new IllegalArgumentException("Значение не может быть <= 0!");
        }
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            synchronized (worksQueue) {
                worksQueue.add(runnable);
                worksQueue.notify();
            }
        }
    }

    public int getThreadsNumber() {
        return threads.length;
    }

    public void interruptAll() {
        System.out.println("Interrupt All Start!");
        for (int i = 0; i < threads.length; i++) {
            worksQueue.clear();
            appStop = true;
            threads[i].interrupt();
            System.out.println("interrupt " + threads[i].getName());
        }
        System.out.println("Interrupt All Finish!");
    }

    private class Worker extends Thread {
        @Override
        public void run() {
            while (!interrupted() && !appStop) {
                Runnable runnable;
                synchronized (worksQueue) {
                    while (worksQueue.isEmpty() && !appStop) {
                        try {
                            //System.out.println("Поток " + Thread.currentThread().getName() + ", жду работу!");
                            worksQueue.wait();
                        } catch (InterruptedException e) {
                            interrupt();
                        }
                    }

                    if (!appStop) {
                        runnable = worksQueue.poll();
                        runnable.run();
                    }
                }
                try {
                    //System.out.println("Поток " + Thread.currentThread().getName() + ", жду работу!");
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    //System.err.println(" end sleep " + Thread.currentThread().getName());
                    //e.printStackTrace();
                    interrupt();
                }
            }
        }
    }
}
