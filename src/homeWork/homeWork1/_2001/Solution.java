package homeWork.homeWork1._2001;

import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < 2; i++) {
            sum += scanner.nextInt();
        }
        System.out.println(sum);
    }
}