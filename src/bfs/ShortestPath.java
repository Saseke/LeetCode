package bfs;

/**
 * @Author Yoke
 * @Date 2018/10/24 上午9:48
 */
public class ShortestPath {
    private int V;

    int minDistance(int dist[], Boolean sptSet[]) {
        int index_min = -1, distance = Integer.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if (!sptSet[i] && dist[i] <= distance) {
                index_min = i;
                distance = dist[i];
            }
        }
        return index_min;
    }

    public ShortestPath(int v) {
        V = v;
    }

    public void dijkstra(int grapg[][], int src) {
        Boolean[] sptSet = new Boolean[V];
        int[] dist = new int[V];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < V - 1; count++) {
            int e = minDistance(dist, sptSet);
            sptSet[e] = true;
            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && grapg[e][v] != 0 && dist[e] != Integer.MAX_VALUE && dist[e] + grapg[e][v] < dist[v]) {
                    dist[v] = dist[e] + grapg[e][v];
                }
            }
        }
        printDistance(dist);
    }

    public void printDistance(int[] dist) {
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + "distance is" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        ShortestPath t = new ShortestPath(graph.length);
        t.dijkstra(graph, 0);
    }
}
