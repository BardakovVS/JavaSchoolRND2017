package homeWork.homeWork9.src.main.java;

import java.lang.reflect.Method;

public class CacheInfoPars {

    public boolean cacheInFile(Method method) {
        if (method.getAnnotation(CacheInfo.class).cacheType() == Enums.FILE) {
            return true;
        } else {
            return false;
        }
    }


    public String keyFromArgs(Method method, Object[] args) {
        String result = new String();
        for (int i = 0; i < method.getAnnotation(CacheInfo.class).identityBy().length; i++) {
            for (int j = 0; j < args.length; j++) {
                if (method.getAnnotation(CacheInfo.class).identityBy()[i].equals(args[j].getClass())) {
                    result += (String) args[j].toString();
                }
            }
        }
        //System.out.println("keyFromArgs: " + result);
        return result;
    }

    public String fileName(Method method) {
        return method.getAnnotation(CacheInfo.class).fileName();
    }
}

