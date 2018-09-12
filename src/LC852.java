/**
 * @author ethereal
 * @since 2018-09-07 8:01 AM
 */
public class LC852 {
    public static void main(String[] args) {
        int[] A = new int[]{0, 2, 1, 0};
        System.out.println(peakIndexInMountainArray(A));
    }

    public static int peakIndexInMountainArray(int[] A) {
        int cur, next, i;
        for (i = 0; i < A.length; i++) {
            cur = A[i];
            next = A[i + 1];
            if (cur > next) {
                return i;
            }
        }
        return i;
    }
}
