package homeWork.homeWork13.z1;


import java.util.concurrent.Callable;

public class Task<T> {
    private final Callable<? extends T> callable;
    private T result;
    private RuntimeException e;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get(String s) throws Exception {
        if (e != null) {
            System.out.println("Exception in Task.get().  " + s);
            throw e;
        }
        if (result == null) {
            synchronized (callable) {
                if (result == null) {
                    try {
                        result = callable.call();
                        System.out.println("New result.   " + s);
                        return result;
                    } catch (Exception e) {
                        this.e = new RuntimeException(e);
                        throw e;
                    }
                } else {
                    if (e != null) {
                        System.out.println("New exception throwing.   " + s);
                        throw e;
                    }
                }
            }
        }
        System.out.println("Result from cache.   " + s);
        return result;
    }

}
