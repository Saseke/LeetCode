import java.util.HashMap;

/**
 * @author Yoke
 * Created on 2018/6/28
 */
public class LC001 {
    // 第一种算法: 暴力法,时间复杂度O(n^2),空间复杂度O(1)
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    // 利用了Map,两遍哈希表，时间复杂度O(n),空间复杂度O(n)
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num) && map.get(num) != i) {
                return new int[]{i, map.get(num)};
            }
        }
        return new int[]{0, 0};
    }

    // 利用Map，一次遍历哈希表，在加入哈希表的同时，插入
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num) && map.get(num) != i) {
                return new int[]{i, map.get(num)};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
