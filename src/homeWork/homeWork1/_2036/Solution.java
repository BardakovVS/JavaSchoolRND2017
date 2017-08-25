package homeWork.homeWork1._2036;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] mas = new String[scanner.nextInt()];
        for (int i = 0; i < mas.length; i++) mas[i] = scanner.next();
        for (String s : mas) if (ss(s)) System.out.println(s);
    }

    public static boolean ss(String s) {
        boolean b = true;
        for (int i = 0; i < s.length() - 2; i++) {
            if ((s.substring(i, i + 1).equals("e") || s.substring(i, i + 1).equals("y") ||
                    s.substring(i, i + 1).equals("u") || s.substring(i, i + 1).equals("i") ||
                    s.substring(i, i + 1).equals("o") || s.substring(i, i + 1).equals("a")) &&
                    (s.substring(i + 1, i + 2).equals("e") || s.substring(i + 1, i + 2).equals("y") ||
                            s.substring(i + 1, i + 2).equals("u") || s.substring(i + 1, i + 2).equals("i") ||
                            s.substring(i + 1, i + 2).equals("o") || s.substring(i + 1, i + 2).equals("a")) &&
                    (s.substring(i + 2, i + 3).equals("e") || s.substring(i + 2, i + 3).equals("y") ||
                            s.substring(i + 2, i + 3).equals("u") || s.substring(i + 2, i + 3).equals("i") ||
                            s.substring(i + 2, i + 3).equals("o") || s.substring(i + 2, i + 3).equals("a")))
                b = false;
        }
        return b;
    }
}
