package greedy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Yoke
 * @Date 2018/10/14 上午10:37
 */
public class LC649 {

    private final String r = "Radiant";
    private final String d = "Dire";

    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        char[] chars = senate.toCharArray();
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            if (c == 'R') {
                rQueue.offer(i);
            } else {
                dQueue.offer(i);
            }
        }
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int rI = rQueue.poll();
            int dI = dQueue.poll();
            if (rI < dI) {
                rQueue.offer(rI + length);
            } else {
                dQueue.offer(dI + length);
            }
        }
        if (rQueue.size() > dQueue.size()) {
            return r;
        } else {
            return d;
        }
    }

    public static void main(String[] args) {
        LC649 lc649 = new LC649();
        System.out.println(lc649.predictPartyVictory("RD"));
    }
}