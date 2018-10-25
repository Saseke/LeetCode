package dfs;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author Yoke
 * @Date 2018/10/24 上午10:22
 */
public class LC787Better {

    private class City implements Comparable<City> {

        int id;
        int costFromSrc;
        int stopFromSrc;

        public City(int id, int costFromSrc, int stopFromSrc) {
            this.id = id;
            this.costFromSrc = costFromSrc;
            this.stopFromSrc = stopFromSrc;
        }

        @Override
        public int compareTo(City city) {
            return this.costFromSrc - city.costFromSrc;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//        将数据存入二维数组中
        int[][] data = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            data[flights[i][0]][flights[i][1]] = flights[i][2];
        }
//        构造优先最小堆
        PriorityQueue<City> minHeap = new PriorityQueue<>();
        minHeap.offer(new City(src, 0, 0));
//        构造cost[]数组,意思是src到其他节点的路径全为无穷大
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
//        构造stop的数组
        int[] stop = new int[n];
        Arrays.fill(stop, Integer.MAX_VALUE);
        stop[src] = 0;
//        循环优先队列,进行判断
        while (!minHeap.isEmpty()) {
            City tmp = minHeap.poll();
            if (tmp.id == dst) return tmp.costFromSrc;
            if (tmp.stopFromSrc == K + 1) continue;
            int[] cities = data[tmp.id];
            for (int i = 0; i < cities.length; i++) {
                if (cities[i] != 0) {
                    int newCost = tmp.costFromSrc + cities[i];
                    int newStop = tmp.stopFromSrc + 1;
                    if (newCost < cost[i]) {
                        minHeap.offer(new City(i, newCost, newStop));
                        cost[i] = newCost;
                    } else if (newStop < stop[i]) {
                        minHeap.offer(new City(i, newCost, newStop));
                        stop[i] = newStop;
                    }
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
//        如果当前弹出的城市的id为dst,直接return
//        如果当前的步数已经超出约定的范围,下一步
//        循环遍历该城市能通往的其他城市
//        如何城市没有走过,得到新的cost,和新的stop,如果newcost<cost,添加到优先堆
//        如果newcost>cost,但是stop的数<当前stop的,添加到优先堆
    }
}

