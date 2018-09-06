import tree.TreeNode;

/**
 * @Author Yoke
 * @Date 7/22/18 9:51 AM
 */
public class LC872 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(79);
        root1.right = new TreeNode(25);
        root1.right.left = new TreeNode(112);
        root1.right.left.left = new TreeNode(74);
        root1.right.left.right = new TreeNode(49);
        root1.right.right = new TreeNode(7);
        root1.right.right.left = new TreeNode(2);
        root1.right.right.right = new TreeNode(122);
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        leafSimilar(root1, root2);
    }

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        int[] a = getLeaf(root1);
        System.out.print("第一颗树叶子节点");
        for (int anA : a) {
            System.out.print(anA + "  ");
        }
        int[] b = getLeaf(root2);
        System.out.print("第二颗树叶子节点");
        for (int aB : b) {
            System.out.print(aB + "  ");
        }
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getLeaf(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        if ((root.left == null) && (root.right == null)) {
            return new int[]{root.val};
        } else {
            int[] leftarr = getLeaf(root.left);
            int[] rightarr = getLeaf(root.right);
            int[] c = new int[leftarr.length + rightarr.length];
            System.arraycopy(leftarr, 0, c, 0, leftarr.length);
            System.arraycopy(rightarr, 0, c, leftarr.length, rightarr.length);
            return c;
        }
    }
}

