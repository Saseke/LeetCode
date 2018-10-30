/**
 * @Author Yoke
 * @Date 2018/10/28 上午10:04
 */
public class LC930 {
    public int numSubarraysWithSum(int[] A, int S) {
        if (A.length==0){
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = A[i];
            if (sum == S) {
                ret++;
            }
            for (int j = i + 1; j < A.length; j++) {
                sum += A[j];
                if (sum == S) {
                    ret++;
                } else if (sum > S) {
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LC930 lc930 = new LC930();
        lc930.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2);
    }
}
