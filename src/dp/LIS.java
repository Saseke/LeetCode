package dp;

/**
 * @Author Yoke
 * @Date 2018/11/10 下午1:09
 */
public class LIS {

    public int lis(int[] a) {
//        状态转移函数 : DP(i) = MAX(DP(j))+1
        int length = a.length;
        int[] dp = new int[a.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    if ((dp[j] + 1) > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        int res = 0;
        for (int num : dp) {
            if (num > res) {
                res = num;
            }
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int size = 0;
        int low, high, mid;
        int[] tail = new int[nums.length];
        for (int i = 0; i < tail.length; i++) tail[i] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            low = 0;
            high = size;
            while (low < high) {
                mid = (high + low) / 2;
                if (tail[mid] < nums[i]) low = mid + 1;
                else high = mid;
            }
            if (nums[i] > tail[low]) {
                size++;
                tail[size - 1] = nums[i];
            }
            if (tail[low] > nums[i]) tail[low] = nums[i];
        }
        return size;
    }

    public void binarySearch(int[] arr, int src, int end, int val) {
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        LIS lis = new LIS();
        System.out.println(lis.lengthOfLIS(nums));
    }
}
