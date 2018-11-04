package dp;

/**
 * @Author Yoke
 * @Date 2018/11/03 下午3:42
 */
public class Fibonacci {
    //    most common version
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //    from top to bottom of Dynamic program
    public void fibonacci(int n) {
        int[] fib = new int[n + 1];
        System.out.println(fib2(n, fib));
    }

    public int fib2(int n, int[] nums) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (nums[n] != 0) {
            return nums[n];
        }
        return fib2(n - 1, nums) + fib2(n - 2, nums);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(6));
        fibonacci.fibonacci(6);
    }
}
