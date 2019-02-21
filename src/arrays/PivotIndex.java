package arrays;

/**
 * @Author Yoke
 * @Date 2019/02/19 上午11:44
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (left == sum - left - cur) {
                return i;
            }
            left += cur;
        }
        return -1;
    }
}
