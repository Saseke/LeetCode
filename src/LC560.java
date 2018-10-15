import java.util.HashMap;
import java.util.Map;

/**
 * @Author Yoke
 * @Date 2018/10/14 下午5:35
 */
public class LC560 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (map.containsKey(curSum - k)) count += map.get(curSum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    public int subarraySum1(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);   //key: preSum, value: frequency
        int count = 0;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (preSum.containsKey(curSum - k)) count += preSum.get(curSum - k);
            // it means there is some sum value v between 0 and x, which makes sum of array [x + 1 to i] == k
            // the frequency is the number of x
            preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        }
        return count;
    }



    public static void main(String[] args) {
        LC560 lc560 = new LC560();
        System.out.println(lc560.subarraySum1(new int[]{1, 1, 1}, 2));
    }
}
