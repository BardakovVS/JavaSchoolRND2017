package homeWork.homeWork1._2025;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[scanner.nextInt()];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        int kz = scanner.nextInt();
        int[][] mz = new int[kz][2];
        for (int i = 0; i < mz.length; i++)
            for (int j = 0; j < mz[i].length; j++)
                mz[i][j] = scanner.nextInt();

        for (int i = 0; i < mz.length; i++) {
            System.out.println(min(mas, mz[i][0], mz[i][1]));
        }
    }

    public static int min(int[] mas, int l, int r) {
        int tmp = mas[l - 1];
        for (int i = l; i < r; i++) {
            if (mas[i] < tmp) tmp = mas[i];
        }
        return tmp;
    }
}

