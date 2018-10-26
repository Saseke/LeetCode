/**
 * @Author Yoke
 * @Date 2018/10/25 上午8:39
 */
public class LC80 {


    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }
        return i;
    }

    public int removeDuplicates1(int[] nums) {
        int count = 0;
        for (int i = 0; i < (nums.length - count); i++) {
            int cur = nums[i];
            if (i + 1 < (nums.length - count) && i + 2 < (nums.length - count)) {
                int next = nums[i + 1];
                if (cur == next && cur == nums[i + 2]) {
                    count++;
                    for (int j = i; j < nums.length - 1; j++) {
                        nums[j] = nums[j + 1];
                    }
                    i--;
                }
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        LC80 lc80 = new LC80();
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int len = lc80.removeDuplicates1(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
