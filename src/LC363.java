import java.util.Set;
import java.util.TreeSet;

/**
 * @author ethereal
 * @since 2018-09-29 10:15
 */
public class LC363 {

    public int maxSumSubmatrix(int[] matrix, int k) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int point = i;
                int temp = 0;
                while (point <= j) {
                    temp += matrix[point];
                    point++;
                }
                if (temp == k) {
                    break;
                }
                if (temp > sum && temp < k) {
                    sum = temp;
                }
            }
            if (sum == k) {
                break;
            }
        }
        return sum;
    }

    public int maxSumSubmatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        int m = Math.min(row, col);
        int n = Math.max(row, col);
        //indicating sum up in every row or every column
        boolean colIsBig = col > row;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] array = new int[n];
            // sum from row j to row i
            for (int j = i; j >= 0; j--) {
                int val = 0;
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                //traverse every column/row and sum up
                for (int k = 0; k < n; k++) {
                    array[k] = array[k] + (colIsBig ? matrix[j][k] : matrix[k][j]);
                    val = val + array[k];
                    //use  TreeMap to binary search previous sum to get possible result
                    Integer subres = set.ceiling(val - target);
                    if (null != subres) {
                        res = Math.max(res, val - subres);
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        System.out.println(((TreeSet) set).ceiling(2));
    }

}
