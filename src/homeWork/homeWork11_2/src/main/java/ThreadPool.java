package homeWork.homeWork11_2.src.main.java;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bardakov_vs on 27.09.2017.
 */
public class ThreadPool implements ThreadPoolInterface {
    private Queue<Runnable> worksQueue = new LinkedList<Runnable>();
    private Thread[] threads;
    private boolean appStop = false;
    private int threadsNumberMin;
    private int threadsNumberMax;
    private boolean killThread = false;
    //private int startedThreads;

    public ThreadPool(int threadsNumberMin) {
        this.threadsNumberMin = threadsNumberMin;
        //this.startedThreads = 0;
        start(threadsNumberMin, threadsNumberMin);
    }

    public ThreadPool(int threadsNumberMin, int threadsNumberMax) {
        this.threadsNumberMin = threadsNumberMin;
        this.threadsNumberMax = threadsNumberMax;
        //this.startedThreads = 0;
        start(threadsNumberMin, threadsNumberMax);
    }

    public void start(int threadsNumberMin, int threadsNumberMax) {
        if (threadsNumberMin > 0 && threadsNumberMin <= threadsNumberMax) {
            threads = new Thread[threadsNumberMax];
            for (int i = 0; i < threadsNumberMin; i++) {
                threads[i] = new Worker();
                //threads[i].setDaemon(true);
                threads[i].start();
            }
        } else {
            throw new IllegalArgumentException("Значение не может быть <= 0! и" +
                    " должно выполняться условие threadsNumberMin <= threadsNumberMax");
        }
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            synchronized (worksQueue) {
                worksQueue.add(runnable);
                if (worksQueue.size() > this.getThreadsNumber() && this.getThreadsNumber() < threadsNumberMax) {
                    threads[this.getThreadsNumber()] = new Worker();
                    //threads[this.getThreadsNumber()+1].setDaemon(true);
                    threads[this.getThreadsNumber() - 1].start();
                    System.err.println("Запущен еще один поток! Всего потоков: " + this.getThreadsNumber());
                }
                /////////////////////
                if (worksQueue.size() < this.getThreadsNumber() && this.getThreadsNumber() > threadsNumberMin) {
                    killThread = true;
                    threads[this.getThreadsNumber()-1].interrupt();
                }
                /////////////////////
                worksQueue.notify();
            }
        }
    }

    public final int getThreadsNumber() {
        int result = 0;
        for (int i = 0; i < threads.length; i++) {
            if (threads[i] != null) result++;
        }
        return result;
    }

    public void interruptAll() {
        System.out.println("Interrupt All Start!");
        for (int i = 0; i < threads.length; i++) {
            if (threads[i] != null) {
                worksQueue.clear();
                appStop = true;
                threads[i].interrupt();
                System.out.println("interrupt " + threads[i].getName());
            }
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
                            System.out.println("****************");
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
                    System.err.println(" end sleep " + Thread.currentThread().getName());
                    //e.printStackTrace();
                    interrupt();
                }
/*                if (killThread) {
                    System.err.println("*** Поток убит! ***");
                    killThread = false;
                    interrupt();
                    interrupted();
                    Thread.currentThread().interrupt();
                }*/
            }
        }
    }
}
