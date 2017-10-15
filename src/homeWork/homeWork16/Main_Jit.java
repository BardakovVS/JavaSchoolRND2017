package homeWork.homeWork16;

import java.util.HashMap;
import java.util.Map;

public class Main_Jit {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            map.put(i, "value" + i);
            //System.out.println(i);
        }
    }
}
