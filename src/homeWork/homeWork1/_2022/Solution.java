package homeWork.homeWork1._2022;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[scanner.nextInt()];
        int k_par = 0;
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if ((mas[j] % mas[i] == 0) && (j != i)) k_par++;
            }
        }
        System.out.println(k_par);
    }
}
