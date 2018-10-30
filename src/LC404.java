import tree.TreeNode;

/**
 * @Author Yoke
 * @Date 2018/10/29 上午9:18
 */
public class LC404 {
    int sum;
    private static final String LEFT = "left";
    private static final String RIGHT = "right";

    public int sumOfLeftLeaves(TreeNode root) {
        find(root, null);
        System.out.println(sum);
        return sum;
    }

    public int find(TreeNode node, String position) {
        if (node == null) {
            return 0;
        }
        if (position != null) {
            if (node.left == null && node.right == null && position.equals(LEFT)) {
                sum += node.val;
                return node.val;
            }
        }
        find(node.left, LEFT);
        find(node.right, RIGHT);
        return 0;
    }

    public static void main(String[] args) {
        LC404 lc404 = new LC404();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        lc404.sumOfLeftLeaves(node);
    }
}
