package homeWork.homeWork1._2005;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int min = scanner.nextInt();
        int ind = 1;
        int tmp;
        for (int i = 1; i < count; i++) {
            tmp = scanner.nextInt();
            if (tmp < min) {
                ind = i + 1;
                min = tmp;
            }
        }
        System.out.println(ind);
    }
}