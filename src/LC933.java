import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/11/04 上午9:43
 */
public class LC933 {

}

class RecentCounter {
    private List<Integer> list;

    public RecentCounter() {
        list = new ArrayList<>();
    }

    public int ping(Integer t) {
        list.add(t);
        if (t <= 3000) {
            return list.size();
        } else {
            Integer min = t - 3000;
            for (int i = 0; i < list.size(); i++) {
                if (min <= list.get(i)) {
                    return list.size() - i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}

