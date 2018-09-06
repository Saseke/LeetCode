import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ethereal
 * @since 2018-09-06 8:13 AM
 */
public class LC113 {

    private static List<List<Integer>> listAll = new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

    }

    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return listAll;
        list.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        list.remove(list.size() - 1);
        return listAll;
    }
}
