package ccf;

import java.util.Scanner;

/**
 * @Author Yoke
 * @Date 2018/12/28 上午8:49
 */
public class BuyVegetables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[1000000];
        int total = 2 * n;
        int firstEnd = 0, secondEnd = 0;
        int count = 0;
        while (total > 0) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if (total == n) {
                firstEnd = end;
            } else if (total == 1) {
                secondEnd = end;
            }
            for (int i = start; i < end; i++) {
                arr[i]++;
            }
            total--;
        }
        int limit = Math.max(firstEnd, secondEnd);
        for (int i = 0; i < limit; i++) {
            if (arr[i] == 2) {
                count++;
            }
        }
        System.out.println(count);
    }
}
