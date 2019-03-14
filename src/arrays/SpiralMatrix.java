package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2019/03/14 上午11:54
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }
        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            for (int i = colBegin; i <= colEnd; i++) {
                ret.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for (int j = rowBegin; j <= rowEnd; j++) {
                ret.add(matrix[j][colEnd]);
            }
            colEnd--;
            for (int i = colEnd; i >= colBegin; i--) {
                ret.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            for (int j = rowEnd; j >= rowBegin; j--) {
                ret.add(matrix[j][colBegin]);
            }
            colBegin++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}
                };
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> list = spiralMatrix.spiralOrder(matrix);
        list.forEach(System.out::println);
    }
}
