import java.util.Arrays;

/**
 * @author ethereal
 * @since 2018-09-01 3:00 PM
 */
// TODO: 9/1/18 动态规划 
public class LC334 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(increasingTriplet2(nums));
    }

    private static boolean increasingTriplet2(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) min = num;
            else if (num < secondMin) secondMin = num;
            else if (num > secondMin) return true;
        }
        return false;
    }

    private static boolean increasingTriplet1(int[] nums) {
        int[] firstNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int[] secondNums = Arrays.copyOf(nums, nums.length);
        int size = nums.length;
        int[][] table = new int[size + 1][size + 1];
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < size + 1; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (firstNums[i - 1] == secondNums[j - 1]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return table[size][size] >= 3;
    }
}
