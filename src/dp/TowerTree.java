package dp;

/**
 * 一个高度为N的由正整数组成的三角形，从上走到下，求经过的数字和的最大值。
 * 每次只能走到下一层相邻的数上，例如从第3层的6向下走，只能走到第4层的2或9上。
 *
 * @Author Yoke
 * @Date 2018/11/10 上午10:47
 */
public class TowerTree {
    private static final Integer FLOOR = 4;
    private int[][] dp = new int[FLOOR][FLOOR];
    private int[][] arr = new int[][]{
            {5},
            {8, 4},
            {3, 6, 9},
            {7, 2, 9, 5}
    };

    private void tower() {
        for (int i = 0; i < FLOOR; i++) {
            dp[FLOOR - 1][i] = arr[FLOOR - 1][i];
        }

        for (int i = FLOOR - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + arr[i][j];
            }
        }
        System.out.println(dp[0][0]);
    }

    public static void main(String[] args) {
        TowerTree tree = new TowerTree();
        tree.tower();
    }
}
