import java.util.LinkedList;

/**
 * @author ethereal
 * @since 2018-09-20 10:04
 */
public class LC189 {

    /**
     * leetcode spends 139 ms
     */
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        LinkedList<Integer> list = new LinkedList();
        for (int i = nums.length - k; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = list.pop();
        }
        for (int i : nums) {
            System.out.println(i);
        }
    }

    /**
     * leetcode spends 0 ms
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;   // prevent k >nums.length
        // reverse total array
        reverse(nums, 0, nums.length - 1);
        // reverse 0 to k-1 of array
        reverse(nums, 0, k - 1);
        // reverse k to nums.length-1
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
