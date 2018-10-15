import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC669 {
    private TreeNode root;


    public TreeNode trimBST2(TreeNode node, int L, int R) {
        if (node == null) {
            return null;
        }
        if (node.val < L) {
            trimBST2(node.right, L, R);
        }
        if (node.val > R) {
            trimBST2(node.left, L, R);
        }
        node.left = trimBST2(node.left, L, R);
        node.right = trimBST2(node.right, L, R);
        return node;
    }

    /**
     * LeetCode costs 57ms
     * First Method :
     * inOrder Traversal node
     * filter out conditions that do not meet the conditions
     * add these numbers to a new Tree
     */
    public TreeNode trimBST(TreeNode node, int L, int R) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(L, R, list, node);
        list.forEach(this::add);
        return root;
    }

    public void add(int n) {
        TreeNode node = new TreeNode(n);
        TreeNode cmp = root;
        TreeNode point = null;
        while (cmp != null) {
            point = cmp;
            if (node.val < cmp.val) {
                cmp = cmp.left;
            } else {
                cmp = cmp.right;
            }
        }
        if (point == null) {
            root = node;
        } else if (point.val < node.val) {
            point.right = node;
        } else {
            point.left = node;
        }
    }

    public void inOrderTraversal(int L, int R, List<Integer> list, TreeNode node) {
        if (node != null) {
            if (node.val >= L && node.val <= R) {
                list.add(node.val);
            }
            inOrderTraversal(L, R, list, node.left);
            inOrderTraversal(L, R, list, node.right);
        }
    }

    public static void main(String[] args) {
        LC669 lc669 = new LC669();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        lc669.trimBST(root, 0, 1);
    }
}
