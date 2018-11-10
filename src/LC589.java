import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Yoke
 * @Date 2018/11/05 上午9:46
 */
public class LC589 {
    private List<Integer> ret = new ArrayList<>();


    /**
     * Iterative Solution
     */
    public List<Integer> preorder1(NaryTree root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<NaryTree> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            NaryTree node = stack.pop();
            list.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return list;
    }

    /**
     * Recursive Solution
     */
    public List<Integer> preorder2(NaryTree root) {
        if (root == null) {
            return ret;
        }
        ret.add(root.val);
        for (NaryTree naryTree : root.children) {
            preorder2(naryTree);
        }
        return ret;
    }
}

class NaryTree {
    public int val;
    public List<NaryTree> children;

    public NaryTree() {
    }

    public NaryTree(int _val, List<NaryTree> _children) {
        val = _val;
        children = _children;
    }
}

