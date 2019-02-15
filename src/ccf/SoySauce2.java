
package ccf;

import java.util.Scanner;

/**
 * @Author Yoke
 * @Date 2019/02/15 下午5:39
 */
public class SoySauce2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N <= 0) {
            System.out.println(0);
        }
        int count1 = N / 50;
        int count2 = (N % 50) / 30;
        int count3 = ((N % 50) % 30) / 10;
        System.out.println(count1 * 7 + count2 * 4 + count3);
    }
}