package homeWork.homeWork1._2056_v1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String words[] = text.split("[^a-zA-Z]");
        int size = words.length;
        String slova[] = new String[size];
        int pos = 0, k = 1, k_max = 1;
        Arrays.fill(slova, "");
        for (int i = 0; i < size; ++i)
            if (!"".equals(words[i])) {
                k = 1;
                for (int j = i; j < size; ++j) {
                    if (words[i].toLowerCase().equals(words[j].toLowerCase())) {
                        k++;
                    }
                }
                if (k > k_max) {
                    Arrays.fill(slova, "");
                    slova[0] = words[i].toLowerCase();
                    pos = 1;
                    k_max = k;
                } else if (k == k_max) {
                    slova[pos] = words[i].toLowerCase();
                    pos++;
                }
            }
        Arrays.sort(slova);
        for (String st : slova){
            if (!st.equals("")){
                System.out.println(st);
            }
        }
    }
}
