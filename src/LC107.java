import tree.TreeNode;

import java.util.*;

public class LC107 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }


    /**
     * 二叉树按层遍历
     *
     * @param root 根节点
     */
    public static void levelIterator(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode current;
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.println("current Node:" + current.val);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return Collections.emptyList();
        }
        cur.offer(root);
        while (!cur.isEmpty()) {
            TreeNode node = cur.poll();
            list.add(node.val);
            if (node.left != null) {
                next.offer(node.left);
            }
            if (node.right != null) {
                next.offer(node.right);
            }
            if (cur.isEmpty()) {
                Queue<TreeNode> tmp = cur;
                cur = next;
                next = tmp;
                res.add(list);
                list = new ArrayList<>();
            }
        }
        Collections.reverse(res);
        return res;
    }
}
