package dp.kadane;

/**
 * @Author Yoke
 * @Date 2018/11/28 下午10:04
 */
//
public class LC53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ret = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            ret = Math.max(ret, sum);
        }
        return ret;
    }

    public static void main(String[] args) {
        LC53 lc53 = new LC53();
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(lc53.maxSubArray(arr));
    }
}
