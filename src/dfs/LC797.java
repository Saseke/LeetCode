package dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Yoke
 * @Date 2018/10/13 上午10:02
 */
public class LC797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Graph graph1 = new Graph(graph.length);
        return graph1.allPathsSourceTarget(graph);
    }
}

class Graph {
    private int V;
    private LinkedList<Integer> linkedLists[];

    Graph(int V) {
        this.V = V;
        linkedLists = new LinkedList[V];
        for (int i = 0; i < linkedLists.length; i++) {
            linkedLists[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int tgt) {
        linkedLists[src].add(tgt);
    }

    public void findPath(int v, int tgt, Stack<Integer> stack, List<List<Integer>> lists) {
        stack.push(v);
        if (v == tgt) {
            List<Integer> list = new LinkedList<>(stack);
            lists.add(list);
        }
        for (Integer node : this.linkedLists[v]) {
            if (!stack.contains(node)) {
                findPath(node, tgt, stack, lists);
                stack.pop();
            }
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Graph gph = new Graph(graph.length);
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                gph.addEdge(i, graph[i][j]);
            }
        }
        List<List<Integer>> lists = new LinkedList<>();
        gph.findPath(0, graph.length - 1, new Stack<>(), lists);
        return lists;
    }
}
