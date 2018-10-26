import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Yoke
 * @Date 2018/10/25 上午9:35
 */
public class LC508 {
    private Integer max = Integer.MIN_VALUE;
    private List<Integer> list = new ArrayList<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        iterator(root, map);
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public int iterator(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        int left = 0, right = 0;
        if (node.left != null) {
            left = iterator(node.left, map);
        }
        if (node.right != null) {
            right = iterator(node.right, map);
        }
        int ret = node.val + left + right;
        int num = map.getOrDefault(ret, 0);
        map.put(ret, ++num);
        if (num > max) {
            max = num;
            list.clear();
            list.add(ret);
        } else if (num == max) {
            list.add(ret);
        }
        return ret;
    }

    public static void main(String[] args) {
        LC508 lc508 = new LC508();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(-3);
        lc508.findFrequentTreeSum(node);
    }
}
