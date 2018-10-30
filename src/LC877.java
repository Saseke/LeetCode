import java.util.LinkedList;

/**
 * @Author Yoke
 * @Date 2018/10/30 上午9:50
 */
public class LC877 {
    public boolean stoneGame(int[] piles) {
        LinkedList<Integer> list = new LinkedList<Integer>() {{
            for (int pile : piles) {
                add(pile);
            }
        }};
        int alexSum = 0, LeeSum = 0;
        int flag = 0;
        while (list.size() != 0) {
            if (flag == 0) {
                alexSum += list.remove(judgePoll(list));
                flag = 1;
            } else {
                LeeSum += list.remove(judgePoll(list));
                flag = 0;
            }
        }
        return alexSum >= LeeSum;
    }

    public int judgePoll(LinkedList<Integer> list) {
        Integer first = list.getFirst();
        Integer last = list.getLast();
        return first > last ? 0 : list.size() - 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 10, 4};
        LC877 lc877 = new LC877();
        lc877.stoneGame(arr);
    }
}
