package homeWork.homeWork13.z1;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        Task<String> task1 = new Task<>(() -> {
            System.out.println("Start task1");
            sleep(2000);
            System.out.println("End task1");
            return "result of task1"+"\n";
        });

        try {
            System.err.println(task1.get("1"));
            System.err.println(task1.get("2"));
            System.err.println(task1.get("3"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-----------------");

        Task<String> task2 = new Task<>(() -> {
            System.out.println("Start task2");
            sleep(3000);
            if (System.currentTimeMillis() % 2 != 5) {
                throw new Exception("Exception task2");
            }
            System.out.println("End task2");
            return "result of task2";
        });

        try {
            System.out.println(task2.get("4"));
        } catch (Exception e) {
            System.out.println("-1-");
            e.printStackTrace();
        }
        try {
            System.out.println(task2.get("5"));
        } catch (Exception e) {
            System.out.println("-2-");
            e.printStackTrace();
        }
        try {
            System.out.println(task2.get("6"));
        } catch (Exception e) {
            System.out.println("-3-");
            e.printStackTrace();
        }

    }
}



















