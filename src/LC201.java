/**
 * @Author Yoke
 * @Date 2018/10/26 上午9:50
 */
public class LC201 {


    /**
     * Time Limit Error
     */
    public int rangeBitwiseAnd1(int m, int n) {
        int ret = 0, count = 0;
        for (int i = m; i <= n; i++) {
            if (count++ == 0) {
                ret = i;
            }
            ret &= i;
        }
        return ret;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int moveFactor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }

    public static void main(String[] args) {
        LC201 lc201 = new LC201();
        lc201.rangeBitwiseAnd2(5, 7);
    }
}
