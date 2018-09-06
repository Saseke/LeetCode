import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author Ethereal
 * @create 2018-08-28-9:05 AM
 */
public class LC506 {
    private static String first = "Gold Medal";
    private static String second = "Silver Medal";
    private static String third = "Bronze Medal";

    public static void main(String[] args) {
        int[] a = new int[]{100, 111, 111111};
        String[] str = findRelativeRanks(a);
        for (String s : str) {
            System.out.println(s);
        }
    }

    public static String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        String[] str = new String[nums.length];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (count == 1) {
                System.out.println(map.get(nums[i]));
                str[map.get(nums[i])] = "Gold Medal";
            } else if (count == 2) {
                str[map.get(nums[i])] = "Silver Medal";
            } else if (count == 3) {
                str[map.get(nums[i])] = "Bronze Medal";
            } else {
                str[map.get(nums[i])] = String.valueOf(count);
            }
            count++;
        }
        return str;
    }
}
