package homeWork.homeWork1._2021;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] m = new int[scanner.nextInt()];
        for (int i = 0; i < m.length; i++) {
            m[i] = scanner.nextInt();
        }
        int max_tmp = max(m);
        for (int i = 0; i < m.length; i++) {
            if (m[i] == max_tmp) m[i] = m[i] / 2;
        }
        max_tmp = max(m);
        for (int i = 0; i < m.length; i++) {
            if (m[i] == max_tmp) m[i] = m[i] / 2;
        }
        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i] + " ");
        }
    }

    public static int max(int[] array) {
        int maximum = array[0];
        for (int i = 0; i < array.length; i++)
            if (maximum < array[i]) maximum = array[i];
        return maximum;
    }
}