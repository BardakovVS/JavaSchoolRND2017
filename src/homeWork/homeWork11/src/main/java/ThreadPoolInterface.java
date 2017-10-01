package homeWork.homeWork11.src.main.java;
/**
 * Created by bardakov_vs on 27.09.2017.
 */
public interface ThreadPoolInterface {
    void start(int i);
    // запускает потоки. Потоки бездействуют, до тех пор пока не появится новое задание в очереди (см. execute)

    void execute(Runnable runnable);
    // складывает это задание в очередь. Освободившийся поток должен выполнить это задание.
    // Каждое задание должны быть выполнено ровно 1 раз
}

