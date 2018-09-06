package methods;

/**
 * @author ethereal
 * @since 2018-09-01 4:35 PM
 */
public class fib {

    public static void main(String[] args) {
        System.out.println(fib1(3));
        System.out.println(fib2(3));
    }

    /**
     * using pure recursion
     */
    static int fib1(int n) {
        if (n < 2)
            return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * using Dynamic Programming
     */
    static int fib2(int n) {
        int[] fibResult = new int[n + 1];
        fibResult[0] = 1;
        fibResult[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibResult[i] = fibResult[i - 1] + fibResult[i - 2];
        }
        return fibResult[n];
    }
}