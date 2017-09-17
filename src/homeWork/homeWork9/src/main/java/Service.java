package homeWork.homeWork9.src.main.java;

public interface Service {
    @CacheInfo(cacheType = Enums./*IN_MEMORY*/FILE, fileName = "сache.data", zip = false, identityBy = {String.class, Double.class})
    double doHardWork(String str, double d);

}
