import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Yoke
 * @Date 2018/11/02 上午11:03
 */
public class LC840 {
    class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length == 0 || grid.length * grid[0].length < 9) {
            return 0;
        }
        List<Node> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 5) {
                    list.add(new Node(i, j));
                }
            }
        }
        for (Node node : list) {
            if (judge(node.row, node.col, grid)) {
                count++;
            }
        }
        return count;
    }

    public boolean judge(int row, int col, int[][] grid) {
        Set<Integer> set = new HashSet<>();
        if (row - 1 >= 0 && col - 1 >= 0 && row + 1 <= grid.length - 1 && col + 1 <= grid.length - 1) {
            int flag = 0;
            for (int i = col - 1; i < col + 1; i++) {
                int curRow = row - 1;
                int curValue = grid[curRow][i];
               /* if (curValue >= 10) {
                    return false;
                }
                if ((curValue & 1) != flag) {
                    return false;
                }
                if (!set.add(curValue)) {
                    return false;
                }*/
                if (curValue >= 10 || (curValue & 1) != flag || !set.add(curValue)) {
                    return false;
                }
                flag = flag == 0 ? 1 : 0;
            }
            flag = 0;
            for (int i = row - 1; i < row + 1; i++) {
                int curCol = col + 1;
                int curValue = grid[i][curCol];
                if (curValue >= 10 || (curValue & 1) != flag || !set.add(curValue)) {
                    return false;
                }
                flag = flag == 0 ? 1 : 0;
            }
            flag = 0;
            for (int i = col + 1; i > col - 1; i--) {
                int curRow = row + 1;
                int curValue = grid[curRow][i];
                if (curValue >= 10 || (curValue & 1) != flag || !set.add(curValue)) {
                    return false;
                }
                flag = flag == 0 ? 1 : 0;
            }
            flag = 0;
            for (int i = row + 1; i > row - 1; i--) {
                int curCol = col - 1;
                int curValue = grid[i][curCol];
                if (curValue >= 10 || (curValue & 1) != flag || !set.add(curValue)) {
                    return false;
                }
                flag = flag == 0 ? 1 : 0;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LC840 lc840 = new LC840();
        int[][] arr = new int[][]{
                {3, 9, 8, 9, 4, 7, 5},
                {3, 4, 9, 2, 3, 1, 8},
                {10, 3, 5, 7, 8, 5, 3},
                {4, 8, 1, 6, 8, 5, 4},
                {3, 5, 7, 10, 5, 9, 1},
                {8, 1, 6, 1, 3, 7, 6},
                {4, 1, 3, 3, 4, 8, 2}};
        System.out.println(lc840.numMagicSquaresInside(arr));
    }
}

