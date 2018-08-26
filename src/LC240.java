/**
 * @author Yoke
 * Created on 2018/8/13
 */
public class LC240 {
    public static void main(String[] args) {
        int[][] arr = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}};
        System.out.println(searchMatrix(arr, 20));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        int row = length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            int value = matrix[row][col];
            if (value == target) {
                return true;
            } else if (value > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
