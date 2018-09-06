public class LC878 {

    private static Integer MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(nthMagicalNumber2(4, 2, 3));
    }


    public static int nthMagicalNumber3(int N, int A, int B) {
        int MOD = 1_000_000_007;
        int L = A / gcd(A, B) * B;

        long lo = 0;
        long hi = (long) 1e15;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            // If there are not enough magic numbers below mi...
            if (mi / A + mi / B - mi / L < N)
                lo = mi + 1;
            else
                hi = mi;
        }

        return (int) (lo % MOD);
    }


    public static int nthMagicalNumber2(int N, int A, int B) {
        int MOD = 1_000_000_007;
        int L = A/gcd(A,B)*B;  // the least common multiple number
        int M = L/A+L/B-1;    // the number of magicalNumber less than or equals L
        int q = N/M,r = N%M;
        long ans = (long) q*L%MOD;
        if (r==0){
            return (int)ans;
        }
        int[] heads = new int[]{A,B};
        for (int i=0;i<r-1;i++){
            if (heads[0]<heads[1]){
                heads[0]+=A;
            }else {
                heads[1]+=B;
            }
        }
        ans+=Math.min(heads[0],heads[1]);
        return (int) (ans%MOD);
    }

    /**
     * calculate  the least common multiple
     *
     * @param x the first param
     * @param y the second param
     * @return return the least common multiple number
     */
    private static int multiple(int x, int y) {
        int maxFactor = gcd(x, y);
        return x / maxFactor * y;
    }

    /**
     * gcd method that caculate the maximum common factor
     *
     * @param x the first param
     * @param y the second param
     * @return return the maximum common factor
     */
    private static int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }

    /**
     * method: time out method
     *
     * @param N th Nth number
     * @param A Factor A
     * @param B Factor B
     * @return the Nth number meets condition
     */
    public static int nthMagicalNumber1(int N, int A, int B) {
        int min = Math.min(A, B);
        int count = 0;
        for (int num = min; num <= MAX; num++) {
            if (num % A == 0 || num % B == 0) {
                count++;
            }
            if (count == N) {
                return num;
            }
        }
        return -1;
    }
}
