/**
 * @Author Yoke
 * @Date 2018/11/18 上午10:32
 */
public class LC941 {
    public static void main(String[] args) {
        LC941 lc941 = new LC941();
        int[] arr = new int[]{2, 5, 5, 1};
        System.out.println(lc941.validMountainArray(arr));
    }

    public boolean validMountainArray(int[] A) {
        int p = -1;
        if (A.length < 3) {
            return false;
        }
        for (int i = 0; i < A.length; i++) {
            if (i + 1 < A.length) {
                if (A[i] > A[i + 1]) {
                    if (i == 0) {
                        return false;
                    }
                    p = i;
                    break;
                } else if (A[i] == A[i + 1]) {
                    return false;
                }
            }
        }
        if (p != -1) {
            for (int i = p; i < A.length; i++) {
                if (i + 1 < A.length) {
                    if (A[i] <= A[i + 1]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
