import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author Yoke
 * @Date 2018/10/15 上午11:17
 */
public class LC519 {

}

class Solution1 {
    Map<Integer, Integer> map;
    int rows, cols, total;
    Random rand;

    public Solution1(int n_rows, int n_cols) {
        map = new HashMap<>();
        rand = new Random();
        rows = n_rows;
        cols = n_cols;
        total = rows * cols;
    }

    public int[] flip() {
        int r = rand.nextInt(total--);
        int x = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(total, total));
        return new int[]{x / cols, x % cols};
    }

    public void reset() {
        map.clear();
        total = rows * cols;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1(2, 3);
        int[] param_1 = solution1.flip();
        int[] param_2 = solution1.flip();
        int[] param_3 = solution1.flip();
        int[] param_4 = solution1.flip();

    }
}
