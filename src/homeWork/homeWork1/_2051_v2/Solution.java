package homeWork.homeWork1._2051_v2;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int ko = 0;
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> stack2 = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        for (int i = 0; i < str.length(); i++) {

            if (str.substring(i, i + 1).equals("(")) {
                stack.push(i + 1);
            }
            if (str.substring(i, i + 1).equals(")")) {
                //System.out.println( stack.pop() + " " + (i + 1)  );
                stack2.put(stack.pop(), i + 1);
            }
        }
        for (int i : stack2.keySet()) {
            System.out.println(i + " " + stack2.get(i));
        }
    }
}
