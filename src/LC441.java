/**
 * @Author Yoke
 * @Date 2018/10/26 上午10:31
 */
public class LC441 {

    public int arrangeCoins3(int n) {
        if (n == 0) {
            return 0;
        }
        Long min = (long) Math.sqrt((double) n);
        Long max = (long) Math.ceil((double) n / 2);
        for (long i = min; i <= max; i++) {
            long sum;
            if ((i & 1) == 1) {
                sum = (1 + i) / 2 * i;
            } else {
                sum = (1 + i) * i / 2;
            }
            if (sum == n) {
                return (int) i;
            } else if (sum > n) {
                return (int) (i - 1);
            } else if (i == max) {
                return (int) i;
            }
        }
        return 0;
    }

    public int arrangeCoins2(int n) {
        if (n == 0) {
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            int sum, nextSum;
            if (i % 2 != 0) {
                sum = (1 + i) / 2 * i;
                nextSum = (i + 2) * (i + 1) / 2;
            } else {
                sum = (1 + i) * i / 2;
                nextSum = (i + 2) / 2 * (i + 1);
            }
            if (sum <= n && nextSum > n) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Time Limit Error
     */
    public int arrangeCoins1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int start = (int) Math.sqrt(n);
        int end = (int) Math.ceil((double) n / 2);
        for (int i = start; i <= end; i++) {
            if (caculateSum(i) <= n && caculateSum(i + 1) > n) {
                return i;
            }
        }
        return -1;
    }

    public int caculateSum(int n) {
        System.out.println((1 + n) / 2 * n);
        if ((1 + n) % 2 == 0) {
            return (1 + n) / 2 * n;
        } else {
            return (1 + n) * n / 2;
        }
    }

    public static void main(String[] args) {
        LC441 lc441 = new LC441();
        System.out.println((1 + 58560) * 50560 / 2);
        System.out.println(lc441.arrangeCoins3(1714636915));
    }
}
