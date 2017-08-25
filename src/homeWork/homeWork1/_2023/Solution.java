package homeWork.homeWork1._2023;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int count = 0;
        Boolean bool = true;
        Scanner scanner = new Scanner(System.in);
        int[] ma = new int[scanner.nextInt()];
        for (int i = 0; i < ma.length; i++) {
            ma[i] = scanner.nextInt();
        }
        int[] mb = new int[scanner.nextInt()];
        for (int i = 0; i < mb.length; i++) {
            mb[i] = scanner.nextInt();
        }
        for (int i = 0; i < ma.length; i++) {
            for (int j = 0; (j < mb.length) && (bool); j++) {
                if (ma[i] == mb[j]) {
                    count++;
                    bool = false;
                }
            }
            bool = true;
        }
        if (count > 0) {
            int[] mc = new int[count];
            int k = 0;
            for (int i = 0; i < ma.length; i++) {
                for (int j = 0; (j < mb.length) && (bool); j++) {
                    if (ma[i] == mb[j]) {
                        mc[k++] = ma[i];
                        bool = false;
                    }
                }
                bool = true;
            }
            System.out.println(count);
            for (int c : mc) System.out.print(c + " ");
        } else {
            System.out.println(count);
        }
    }
}







