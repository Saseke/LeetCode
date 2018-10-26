import java.util.HashSet;
import java.util.Set;

/**
 * @Author Yoke
 * @Date 2018/10/25 上午8:27
 */
public class LC81 {

    public boolean search1(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * Faster than 2.87%
     */
    public boolean search(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.contains(target);
    }
}
