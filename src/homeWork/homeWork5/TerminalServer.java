package homeWork.homeWork5;

import java.util.Map;
import java.util.TreeMap;

public class TerminalServer {
    private Map<String, Integer> ls_sum = new TreeMap<>();


    TerminalServer() {
        this.ls_sum.put("1111111111", 10000);
        this.ls_sum.put("2222222222", 20000);
        this.ls_sum.put("3333333333", 30000);
    }

    public boolean spisanie(String ls, Integer sum) {
        if (this.ls_sum.get(ls) >= sum) {
            if (sum % 100 == 0) {
                System.out.println(this.ls_sum.get(ls));
                this.ls_sum.put(ls, this.ls_sum.get(ls) - sum);
                System.out.println(this.ls_sum.get(ls));
                System.out.println(sum);
                return true;
            } else {
                //return false;
                throw new IllegalArgumentException("Сумма не кратна 100");
            }
        } else {
            return false;
            //throw new
        }
    }

    public boolean popolnenie(String ls, Integer sum) {
        //if (this.ls_sum.get(ls) >= sum) {
        System.out.println(this.ls_sum.get(ls));
        this.ls_sum.put(ls, this.ls_sum.get(ls) + sum);
        System.out.println(this.ls_sum.get(ls));
        System.out.println(sum);
        return true;
        //} else {
        //    return false;
        //}
    }

    public Integer getOstatok(String ls) {
        return this.ls_sum.get(ls);

    }

}
