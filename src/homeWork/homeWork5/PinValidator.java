package homeWork.homeWork5;

import java.util.Map;
import java.util.TreeMap;

public class PinValidator {
    Map<String, Integer> lsPin = new TreeMap<>();


    PinValidator() {
        this.lsPin.put("1111111111", 1111);
        this.lsPin.put("2222222222", 2222);
        this.lsPin.put("3333333333", 3333);
    }

    public boolean validation(String ls, Integer pin) {
        if (this.lsPin.get(ls).equals(pin)) {
//            System.out.println(this.lsPin.get(ls));
//            System.out.println(pin);
            return true;
        } else {
            return false;
        }

    }
}