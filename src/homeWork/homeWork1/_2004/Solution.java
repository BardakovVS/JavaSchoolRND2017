package homeWork.homeWork1._2004;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int y = scanner.nextInt();
        if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}