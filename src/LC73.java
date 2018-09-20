/**
 * @author ethereal
 * @since 2018-09-19 11:52
 */
public class LC73 {

    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    set(matrix, i, j);
                }
            }
        }
    }

    public int[][] set(int[][] matrix, int row, int col) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
        return matrix;
    }

    public static void main(String[] args) {
        LC73 lc73 = new LC73();
        int[][] a = new int[][]{{0, 2}, {1, 2}};
        lc73.set(a, 0, 1);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
