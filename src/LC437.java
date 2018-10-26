import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Yoke
 * @Date 2018/10/25 上午10:44
 */
public class LC437 {

    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        helper(preSum, 0, root, sum);
        return count;
    }

    int helper(Map<Integer, Integer> preSum, int curSum, TreeNode node, int target) {
        if (node == null) {
            return 0;
        }
        curSum += node.val;
        if (preSum.containsKey(curSum - target)) {
            count += preSum.get(curSum - target);
        }
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        helper(preSum, curSum, node.left, target);
        helper(preSum, curSum, node.right, target);
        preSum.put(curSum, preSum.get(curSum) - 1);
        return curSum;
    }

    public static void main(String[] args) {
        LC437 lc437 = new LC437();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(-2);
        node.right = new TreeNode(-3);
        lc437.pathSum(node, -1);
    }
}
