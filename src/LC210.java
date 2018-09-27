import model.graph.Graph;

import java.util.Stack;

/**
 * @author ethereal
 * @since 2018-09-22 11:11
 */
public class LC210 {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        int[] arr = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            graph.addEdge(prerequisite[1], prerequisite[0]);
        }
        Stack<Integer> stack = new Stack<>();
        int[] marks = new int[numCourses];
        for (int i = 0; i < marks.length; i++) {
            marks[i] = -1;
        }
        boolean[] isDAG = new boolean[]{true};
        for (int i = 0; i < numCourses; i++) {
            graph.topologicalSortUtil(i, isDAG, marks, stack);
            if (!isDAG[0]) {
                return new int[0];
            } else if (graph.judge1(marks)) {
                break;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }


    public static void main(String[] args) {
        LC210 lc210 = new LC210();
        int[][] arr = new int[][]{{1, 0}};
        int[] tmp = lc210.findOrder(3, arr);
        for (int i : tmp) {
            System.out.print(i + " ");
        }
    }
}
