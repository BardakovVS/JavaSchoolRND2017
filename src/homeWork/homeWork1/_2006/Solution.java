package homeWork.homeWork1._2006;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sm = scanner.nextInt();
        int d = 0;
        int f = 0;
        if (sm % 3 == 2) {
            d = (sm / 3) + 1;
        } else {
            d = sm / 3;
        }
        f = d / 12;
        d = d % 12;
        System.out.println(f + " " + d);
    }
}