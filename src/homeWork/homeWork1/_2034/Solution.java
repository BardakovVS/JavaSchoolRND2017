package homeWork.homeWork1._2034;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int l = 0;
        int r = 0;
        int kMax = 0; //максимальная длинна подмассива
        boolean b;
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[scanner.nextInt()];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        for (int i = 0; (i < mas.length) && (kMax < mas.length - i); i++) {
            b = true;
            for (int j = i + 1; (j < mas.length) && (kMax < mas.length - i) && (b); j++) {
                b = kons(mas, i, j);
                if (b && (j - i + 1) > kMax) {
                    l = i + 1;
                    r = j + 1;
                    kMax = j - i + 1;
                }
            }
        }
        if (r == 0) {
            l = r = 1;
        }
        System.out.println(l + " " + r);
    }

    private static boolean kons(int[] mas, int l, int r) {
        boolean b = true;
        for (int i = l; (i <= r) && (b); i++)
            for (int j = i + 1; (j <= r) && (b); j++)
                if ((mas[i] - mas[j] > 1) || (mas[i] - mas[j] < -1))
                    b = false;
        return b;
    }
}








