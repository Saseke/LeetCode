package dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Yoke
 * @Date 2018/10/22 上午9:05
 */
public class LC787 {
    Integer index = 0;
    Integer count = 0;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        GraphWithWeight graph = new GraphWithWeight(n);
        for (int[] flight : flights) {
            graph.addEdge(flight[0], flight[1], flight[2]);
        }
        int ret = findPath1(src, dst, 0, new boolean[n], new Stack<>(), Integer.MAX_VALUE, graph, K);
        if (ret == Integer.MAX_VALUE) {
            return -1;
        }
        return ret;
    }

    public int findPath1(int v, int dst, int weight, boolean[] remark, Stack<Integer> weightStack, int ret,
                         GraphWithWeight graph, int k) {
        remark[v] = true;
        weightStack.push(weight);
        if (v == dst && weightStack.size() <= k + 2) {
            int sum = 0;
            for (Integer i : weightStack) {
                sum += i;
            }
            if (sum < ret) {
                ret = sum;
            }
        }
        for (Integer[] node : graph.list[v]) {
            if (!remark[node[0]]) {
                ret = findPath1(node[0], dst, node[1], remark, weightStack, ret, graph, k);
                remark[node[0]] = false;
                weightStack.pop();
            }
        }
        return ret;
    }

    public List<Integer> findPath(int v, int dst, int weight, Stack<Integer> pathStack, Stack<Integer> weightStack,
                                  List<Integer> list,
                                  GraphWithWeight graph, int k) {
        pathStack.push(v);
        weightStack.push(weight);
        if (v == dst) {
            if (weightStack.size() <= k + 2) {
                int sum = 0;
                for (Integer i : weightStack) {
                    sum += i;
                }
                list.add(sum);
            }
        }
        for (Integer[] node : graph.list[v]) {
            if (!pathStack.contains(node[0])) {
                findPath(node[0], dst, node[1], pathStack, weightStack, list, graph, k);
                pathStack.pop();
                weightStack.pop();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LC787 lc787 = new LC787();
//        int[][] arr = {{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}};
        int[][] arr = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(lc787.findCheapestPrice(3, arr, 0, 2, 1));

    }
}

class GraphWithWeight {
    public int v;
    public LinkedList<Integer[]>[] list;

    public GraphWithWeight(int v) {
        this.v = v;
        this.list = new LinkedList[v];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dst, int weight) {
        list[src].add(new Integer[]{dst, weight});
    }
}



