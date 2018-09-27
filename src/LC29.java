/**
 * @author ethereal
 * @since 2018-09-20 11:03
 */
public class LC29 {


    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if (ldividend < ldivisor || ldividend == 0) return 0;

        long lans = ldivide(ldividend, ldivisor);
        int ans;
        if (lans > Integer.MAX_VALUE) {
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }


    public long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    public static void main(String[] args) {
        LC29 lc29 = new LC29();
        System.out.println(lc29.ldivide(100, 3));
    }
}
