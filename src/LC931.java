/**
 * @Author Yoke
 * @Date 2018/10/28 上午10:10
 */
public class LC931 {
    private int sum = 0;
    private int ret = 0;

    public int minFallingPathSum(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            find(0, i, A);
        }
        return sum;
    }

    public int find(int row, int col, int[][] A) {
        if (row == A.length || col == A.length || col == -1) {
            return 0;
        }
        sum += A[row][col];
        if (sum > ret) {
            ret = sum;
        }
        sum -= find(row + 1, col - 1, A);
        sum -= find(row + 1, col, A);
        sum -= find(row + 1, col + 1, A);
        return A[row][col];
    }

    public static void main(String[] args) {
        LC931 lc931 = new LC931();
        lc931.minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
