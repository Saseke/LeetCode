import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/11/01 上午9:28
 */
public class LC102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        return traversal(root);
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (leftHeight >= rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }

    public List<List<Integer>> traversal(TreeNode root) {
        int hegith = height(root);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 1; i <= hegith; i++) {
            List<Integer> list = new ArrayList<>();
            traversalCollect(root, i, list);
            ret.add(list);
        }
        return ret;
    }

    public void traversalCollect(TreeNode node, int level, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            list.add(node.val);
        } else {
            traversalCollect(node.left, level - 1, list);
            traversalCollect(node.right, level - 1, list);
        }
    }

    public void traveralByLevel(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LC102 lc102 = new LC102();
        lc102.traveralByLevel(root);
    }
}
