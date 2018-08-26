import java.util.HashMap;
import java.util.Map;

public class LC447 {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int ret = 0;
        if (points.length < 3) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                Integer distance = distance(points[i], points[j]);
                map.merge(distance, 1, (a, b) -> a + b);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getValue();
                if (num == 1) continue;
                ret += num * (num - 1);
            }
            map.clear();
        }

        return ret;
    }

    private static Integer distance(int[] pointA, int[] pointB) {
        int x = Math.abs(pointA[0] - pointB[0]);
        int y = Math.abs(pointA[1] - pointB[1]);
        return x * x + y * y;
    }
}
