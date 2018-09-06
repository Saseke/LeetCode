import tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ethereal
 * @create 2018-08-27-10:00 AM
 */
public class LC671 {

    private static Set<Integer> set = new HashSet();
    private static Integer min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(findSecondMinimumValue(root));
    }

    private static int findSecondMinimumValue(TreeNode root) {
        addNodeToSet(root);
        set.remove(min);
        min = Integer.MAX_VALUE;
        if (set.size() == 0) {
            return -1;
        }
        for (Integer i : set) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public static void addNodeToSet(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val < min) {
            min = node.val;
        }
        set.add(node.val);
        addNodeToSet(node.left);
        addNodeToSet(node.right);
    }
}
