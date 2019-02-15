package ccf;

import java.util.Scanner;

/**
 * @Author Yoke
 * @Date 2019/02/15 下午5:21
 */
public class SoySauce1 {
    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N <= 0) {
            System.out.println(0);
        }
        N = sale1(N);
        N = sale2(N);
        count += N / 10;
        System.out.println(count);
    }


    public static int sale1(int money) {
        int param = money / 10;
        int noSaleCount = param / 5;
        if (noSaleCount != 0) {
            count += noSaleCount * 7;
            return (param % 5) * 10;
        }
        return money;
    }

    public static int sale2(int money) {
        int param = money / 10;
        int result = param / 3;
        if (result != 0) {
            count += result * 4;
            return (param % 3) * 10;
        }
        return money;
    }
}
