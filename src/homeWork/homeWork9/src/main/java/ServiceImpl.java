package homeWork.homeWork9.src.main.java;

public class ServiceImpl implements Service/*, Serializable*/ {
    @Override
    public double doHardWork(String str, double dd) {

        int j = 0;
        for (int i = 1; i < str.length() + 1; i++) {
            j += str.codePointBefore(i);
        }
        return j / (dd * 1.0);


    }

//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.defaultWriteObject();
//        out.writeLong(Calendar.getInstance().getTimeInMillis());
//    }
//
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        in.defaultReadObject();
//        long writeTime = in.readLong();
//        System.out.println(writeTime);
//    }
}
