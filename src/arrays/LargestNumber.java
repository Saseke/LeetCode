package arrays;

/**
 * @Author Yoke
 * @Date 2019/02/19 下午1:17
 */
public class LargestNumber {
    public int dominantIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return 0;
        } else {
            int largestNum = nums[0], secondNum = Integer.MIN_VALUE, index = 0;
            for (int i = 1; i < nums.length; i++) {
                int cur = nums[i];
                if (cur > largestNum) {
                    secondNum = largestNum;
                    largestNum = cur;
                    index = i;
                } else if (cur > secondNum) {
                    secondNum = cur;
                }
            }
            if (largestNum >= secondNum * 2) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
