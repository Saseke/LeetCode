package dp;

/**
 * @Author Yoke
 * @Date 2018/11/11 上午10:50
 */
public class LC198 {
    public int rob(int[] nums) {
//        只有一个 :[4]
//        抢value 4
//        [4,1]
//        value: 4
//        [4,1,3]
//        D[i] = max(D[i-1],D[i-2]+num[i])
//   D[0]=4
//   D[1] = 4;
//   D[2] = max(4,7)=7
//       [4,1,3,2]
//   D[3]     = max(D[2],D[1]+2) = 7
//       [4,1,3,2,8]
//    D[4] = max(D[3],D[2]+8) = 15

        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.length - 1];
        }
    }

    public static void main(String[] args) {
        LC198 lc198 = new LC198();
        int[] arr = new int[]{2, 7, 9, 3, 1};
        System.out.println(lc198.rob(arr));
    }
}