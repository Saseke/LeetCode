package methods;

/**
 * @author ethereal
 * @since 2018-09-01 3:01 PM
 */

/**
 * solve the Longest Increasing Subsequence
 */
public class LIS {
    /**
     * convert to the longest common subsequence
     */
    private static int lcs(char[] x, char[] y, int m, int n) {
        int[][] table = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return table[m][n];
    }


    public static void main(String[] args) {
        String X = "111111";
        String Y = "111111";
        System.out.println(lcs(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
    }
}
