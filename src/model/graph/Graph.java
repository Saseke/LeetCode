package model.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author ethereal
 * @since 2018-09-25 09:27
 */
public class Graph {
    private int v;
    private LinkedList<Integer>[] adjListArray;
    private int count = 0;


    public Graph(int v) {
        this.v = v;
        adjListArray = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        count++;
        adjListArray[src].add(dest);
    }

    public void printf(Graph graph) {
        for (int i = 0; i < v; i++) {
            System.out.println("current array of list is " + i);
            System.out.print("head");
            for (Integer j : graph.adjListArray[i]) {
                System.out.print(" - > " + j);
            }
            System.out.println();
        }
    }

    public void DFS1(int start, boolean[] marks) {
        marks[start] = true;
        count++;
        System.out.print(start + " ");
        for (Integer i : adjListArray[start]) {
            if (!marks[i]) {
                DFS1(i, marks);
            }
        }
    }

    public void DFS2(int p, boolean[] marks, List<Integer> path) {
        for (int i = 0; i < adjListArray[p].size(); i++) {
            int np = adjListArray[p].get(i);
            if (!marks[p]) {
                marks[p] = true;
                path.add(p);
                if (judge(marks)) {
                    System.out.printf("第%d方案", ++count);
                    for (Integer integer : path) {
                        System.out.print(integer + "  ");
                    }
                    System.out.println();
                } else {
                    DFS2(np, marks, path);
                }
                marks[p] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean DFS3(int p, int[] marks, List<Integer> path) {
        for (int i = 0; i < adjListArray[p].size(); i++) {
            int np = adjListArray[p].get(i);
            if (marks[p] == -1) {
                marks[p] = 0;
                path.add(p);
                if (judge1(marks)) {
                    System.out.printf("第%d方案", ++count);
                    for (Integer integer : path) {
                        System.out.print(integer + "  ");
                    }
                    System.out.println();
                } else if (marks[np] == -1) {
                    if (!DFS3(np, marks, path)) {
                        return false;
                    }
                } else if (marks[np] == 0) {
                    return false;
                }
                marks[p] = -1;
                path.remove(path.size() - 1);
            }
        }
        marks[p] = 1;
        return true;
    }

    public void topologicalSortUtil(int p, boolean[] isDAG, int[] marks, Stack<Integer> stack) {
        if (!isDAG[0]) {
            return;
        }
        if (marks[p] == 1) {
            return;
        }
        marks[p] = 0;
        for (Integer i : adjListArray[p]) {
            if (!judge1(marks)) {
                if (marks[i] == -1) {
                    topologicalSortUtil(i, isDAG, marks, stack);
                } else if (marks[i] == 0) {
                    isDAG[0] = false;
                }
            }
        }
        marks[p] = 1;
        stack.push(p);
    }

    /*public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] marks = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!marks[i]) {
                topologicalSortUtil(i, true, marks, stack);
            }
        }
        while (!stack.empty()) {
            System.out.println(stack.pop() + " ");
        }
    }*/

    public boolean judge(boolean[] marks) {
        for (boolean b : marks) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public boolean judge1(int[] marks) {
        for (int b : marks) {
            if (b == -1 || b == 0) {
                return false;
            }
        }
        return true;
    }

    /*public static void main(String[] args) {
        Graph g = new Graph(2);
        g.addEdge(0, 1);
        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }*/

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
