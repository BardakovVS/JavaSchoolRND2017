package homeWork.homeWork1._2038;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chArr = str.toCharArray();
        byte[] bytes = str.getBytes("ascii");
        int k = 0;
        int k_max = 0;
        for (int i = 0; i < chArr.length; i++) {
            if (((bytes[i] > 64) && (bytes[i] < 91)) || ((bytes[i] > 96) && (bytes[i] < 123))) {
                k++;
                if (k > k_max) {
                    k_max = k;
                }
            } else {
                k = 0;
            }
        }
        System.out.println(k_max);
    }
}
