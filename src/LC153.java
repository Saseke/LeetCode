/**
 * @Author Yoke
 * @Date 2018/11/01 上午9:00
 */
public class LC153 {
    int min = Integer.MAX_VALUE;

    public int findMin(int[] nums) {
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
