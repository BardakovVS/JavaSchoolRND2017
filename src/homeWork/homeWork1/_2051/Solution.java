package homeWork.homeWork1._2051;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int ko = 0;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 1).equals("(")) {
                ko++;
                for (int j = i + 1; (j < str.length()) && (ko > 0); j++) {
                    if (str.substring(j, j + 1).equals(")")) {
                        ko--;
                        if (ko == 0) System.out.println((i + 1) + " " + (j + 1));
                    } else ko++;
                }
            }
        }
    }
}
