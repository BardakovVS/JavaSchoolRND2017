package homeWork.homeWork1._2024;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int k = 0;
        Scanner scanner = new Scanner(System.in);
        int[] ma = new int[scanner.nextInt()];
        for (int i = 0; i < ma.length; i++) {
            ma[i] = scanner.nextInt();
        }
        for (int i = 0; i < (ma.length / 2); i++) {
            if (ma[i] == ma[ma.length - 1 - i]) k++;
        }
        System.out.println((ma.length / 2) - k);
    }
}
