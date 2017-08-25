package homeWork.homeWork1._2007;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = 0;
        String s = Integer.toString(n, 2);
        char[] chArray = s.toCharArray();
        if (chArray.length > 0) {
            if (chArray[chArray.length - 1] == '0') {
                k++;
                for (int i = chArray.length - 2; (i >= 0) && (chArray[i] == '0'); i--) {
                    if (chArray[i] == '0') {
                        k++;
                    }
                }
            }
        }
        System.out.println(k);
    }
}

