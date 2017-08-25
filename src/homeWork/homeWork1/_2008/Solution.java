package homeWork.homeWork1._2008;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas_gr = new int[scanner.nextInt()];
        int w = scanner.nextInt();
        int kol = 0;
        int all_gr = 0;
        for (int i = 0; i < mas_gr.length; i++) {
            mas_gr[i] = scanner.nextInt();
        }

        for (int i = 0; i < mas_gr.length; i++) {
            //System.out.print(mas_gr[i] + " ");
            if (w - mas_gr[i] >= 0) {
                w = w - mas_gr[i];
                kol++;
                all_gr = all_gr + mas_gr[i];
            }
        }
        System.out.println(kol + " " + all_gr);
    }
}

