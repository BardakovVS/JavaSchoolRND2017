package homeWork.homeWork1._2019;

        import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println((int) Math.ceil((Math.sqrt(8 * n + 1D) - 1) / 2));
    }
}
