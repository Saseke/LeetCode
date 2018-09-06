import tree.TreeNode;

/**
 * @Author Yoke
 * @Date 7/18/18 10:38 PM
 */
public class LC110Better {
    public static boolean isBalanced(TreeNode root) {
        return helper(root) != Integer.MIN_VALUE;
    }

    static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHelper = helper(root.left);
        if (leftHelper == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int rightHelper = helper(root.right);
        if (rightHelper == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int diff = Math.abs(leftHelper - rightHelper);
        if (diff > 1) {
            return Integer.MIN_VALUE;
        }
        return 1 + Math.max(leftHelper, rightHelper);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(isBalanced(node));
    }
}
