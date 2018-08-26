import java.util.ArrayList;
import java.util.List;

public class LC107Better {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int depth = maxDepth(root);
        for (int i = 0; i < depth; i++) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
        return order(root, 0, result);
    }

    private static List<List<Integer>> order(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null) {
            return result;
        }
        result.get(result.size() - depth - 1).add(root.val);
        order(root.left, depth + 1, result);
        order(root.right, depth + 1, result);
        return result;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        if (left >= right) {
            return left;
        }
        return right;
    }
}
