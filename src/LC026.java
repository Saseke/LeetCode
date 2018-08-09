/**
 * @Author Yoke
 * @Date 7/19/18 9:45 PM
 */
public class LC026 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 2, 2};
        int len = removeDeplicates1(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDeplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeDeplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int pre = nums[0];
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) continue;
            nums[length] = nums[i];
            pre = nums[i];
            length++;
        }
        return length;
    }
}
