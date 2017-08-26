package homeWork.homeWork1._2003;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int sum = 0 + scanner.nextInt();
        for (int i = 1; i < count; i++) {
            if (i % 2 == 0) {
                sum += scanner.nextInt();
            } else {
                sum -= scanner.nextInt();
            }
        }
        System.out.println(sum);
    }
}
