import tree.TreeNode;

/**
 * @Author Yoke
 * @Date 7/15/18 7:44 PM
 */
public class LC110 {
    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        int diff = Math.abs(leftDepth - rightDepth);
        if (diff > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int treeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = treeDepth(node.left);
        int rightDepth = treeDepth(node.right);
        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
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

