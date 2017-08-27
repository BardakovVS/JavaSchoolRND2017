package homeWork.homeWork3._2057;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Deque<Integer> stack = new LinkedList<>();
        int n = scanner.nextInt();
        int /*i = 0,*/ j = 0;
        int tempScaner;
        while (/*(i < n) & */(j < n)) {
            tempScaner = scanner.nextInt();
            if (tempScaner == 1) {
                pq.add(scanner.nextInt());
               // i--;
                //System.out.println(pq.toString());
            } else if (tempScaner == 2) {
                //System.out.println(pq.peek());
                stack.add(pq.peek());
                pq.remove(pq.peek());
                //System.out.println(pq.toString());
            }
           // i++;
            j++;
        }
        for (Integer iStack : stack) {
            System.out.println(iStack);
        }
    }
}