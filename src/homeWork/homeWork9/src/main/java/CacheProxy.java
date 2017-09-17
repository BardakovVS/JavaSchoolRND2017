package homeWork.homeWork9.src.main.java;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy {
    private static String folder;

    public CacheProxy(String folder) {
        if (!folder.equals("")) {
            this.folder = folder + "/";
        } else {
            this.folder = folder;
        }
    }

    private static class InvocationHandlerImpl<T> implements InvocationHandler {
        private T t;
        private Map<String, Object> cache = new HashMap<>();
        private Map<String, Object> cacheSer;
        private CacheInfoPars cacheInfoPars = new CacheInfoPars();

        public InvocationHandlerImpl(T t, String folder) {
            this.t = t;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable/*, IOException*/ {
            Object result = new Object();
//            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("cache.dat"));
            if (method.isAnnotationPresent(CacheInfo.class)) {
                if ((cacheSer == null) && (cacheInfoPars.cacheInFile(method))) {
                    try {
                        //System.out.println(folder + "cache.dat");
                        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(folder +
                                cacheInfoPars.fileName(method)));
                        cacheSer = (Map<String, Object>) inputStream.readObject();
                        cache = cacheSer;
                        inputStream.close();
                        //System.out.println("Десериализация cache");
                    } catch (FileNotFoundException e) {
                        System.out.println("Десериализация не выполнена!" + e.getMessage());
                    }
                }
                if (cache.containsKey(cacheInfoPars.keyFromArgs(method, args))) {
                    result = cache.get(cacheInfoPars.keyFromArgs(method, args));
                    System.out.println("doHardWork=> args[0]:" + args[0] + "  args[1]:" + args[1] + " result:" + result + " Из кеша");
                    //return result;
                } else {
                    result = method.invoke(t, args);
                    System.out.println("doHardWork=> args[0]:" + args[0] + "  args[1]:" + args[1] + " result:" + result + " Посчитано");
                    cache.put(cacheInfoPars.keyFromArgs(method, args), result);
                    if (cacheInfoPars.cacheInFile(method)) {
                        try {
                            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(folder +
                                    cacheInfoPars.fileName(method)));
                            outputStream.writeUnshared(cache);
                            //System.out.println("Сериализация cache");
                            outputStream.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("Кеш не может быть сохранен! " + e.getMessage());
                        }
                    }
                    //return result;
                }

            } else {
                System.out.println("Return from invoke - method not marked. Method: " + method.getName());
                result = method.invoke(t, args);
            }
/*            if (cacheInfoPars.cacheInFile(method)) {
                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(folder +
                            cacheInfoPars.fileName(method)));
                    outputStream.writeUnshared(cache);
                    //System.out.println("Сериализация cache");
                    outputStream.close();
                } catch (FileNotFoundException e){
                    System.out.println("Кеш не может быть сохранен! " + e.getMessage());
                }
            }*/
            return result;
        }
    }

    public static <T> T cache(T t) {

        Object result = Proxy.newProxyInstance(t.getClass().getClassLoader(),
                t.getClass().getInterfaces(), new InvocationHandlerImpl<>(t, folder));

        return (T) result;
    }

}

