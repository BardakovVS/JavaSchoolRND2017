package homeWork.homeWork9.src.main.java;

/**
 * Created by bardakov_vs on 15.09.2017.
 */
public class Test {
    public static void main(String[] args) {
/*        Service service = new Service();
        double r1 = service.doHardWork("work1", 10);
        System.out.println(r1);*/


        CacheProxy cacheProxy = new CacheProxy("src\\homeWork\\homeWork9\\temp");
        Service service = cacheProxy.cache(new ServiceImpl());
        double r1 = service.doHardWork("work1", 10);
        double r2 = service.doHardWork("work2", 5);
        double r3 = service.doHardWork("work1", 10);
        double r4 = service.doHardWork("work2", 10);
//        double r5 = service.doHardWork("work3", 10);
//        double r6 = service.doHardWork("work2", 5);
//        double r7 = service.doHardWork("work5", 5);


    }
}
