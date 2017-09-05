package homeWork.homeWork6;


import javax.swing.*;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MyProxy implements InvocationHandler {
    private final Object target;

    private static void appendUsingFileWriter(String filePath, String text) {
        File file = new File(filePath);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            fr.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public MyProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = new Object();
        Boolean resultBool = false;
        File file = null;
        Path path = Paths.get(".");
        file = new File(path.toRealPath(LinkOption.NOFOLLOW_LINKS) + "\\src\\homeWork\\homeWork6\\proxycache.txt");

        Map<String, String> proxycache = new TreeMap<>();
        try (BufferedReader BR = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = BR.readLine()) != null) {
                String[] tempStr = str.split(" ");
                proxycache.put(tempStr[0], tempStr[1]);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ошибка чтения из файл");
        }

        System.out.println("Started " + method.getName());
        //System.out.println("Arg: " + Arrays.hashCode(args));
        //System.out.println("target: " + target);

        for (String tempStr : proxycache.keySet()) {
            if (String.valueOf(Arrays.hashCode(args)).equals(tempStr)) {
                result = proxycache.get(tempStr);
                resultBool = true;
                System.out.println("Результат из кеша.");
            }
        }
        if (!resultBool) {
            result = method.invoke(target, args);
            System.out.println("Результат посчитан.");


            try {
                appendUsingFileWriter(file.getPath(), "\n" + Arrays.hashCode(args) + " " + result);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ошибка записи в файл");
            }
        }
        System.out.println("Finished " + method.getName() + ".Result " + result);
        System.out.println();
        return result;
    }
}
