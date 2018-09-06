import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ethereal
 * @since 2018-09-05 7:17 AM
 */
public class LC114 {

    private static TreeNode prev = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        flatten1(root);
    }


    /**
     * put tree.TreeNode data info List
     */
    private static void flatten2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).right = list.get(i);
            list.get(i - 1).left = null;
        }
    }

    private static void traverse(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            traverse(root.left, list);
            traverse(root.right, list);
        }
    }

    private static void flatten1(TreeNode root) {
        if (root == null)
            return;
        flatten1(root.right);
        flatten1(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    /**
     * non recursive implementation
     */
    private static void depthOrderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * recursive implementation
     */

    private static void depthOrderTraversal1(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            depthOrderTraversal1(root.left);
            depthOrderTraversal1(root.right);
        }
    }
}
