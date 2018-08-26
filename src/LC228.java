import java.util.ArrayList;
import java.util.List;

/**
 * @author Yoke
 * Created on 2018/8/9
 */
public class LC228 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        summaryRanges(arr).forEach(System.out::println);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int cur = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i + 1) < nums.length) {
                if (nums[i] + 1 == nums[i + 1]) {
                    count++;
                } else {
                    String s;
                    if (count == 0) {
                        s = String.valueOf(nums[i]);
                    } else {
                        s = nums[cur] + "->" + nums[cur + count];
                    }
                    cur = cur + count + 1;
                    count = 0;
                    list.add(s);
                }
            } else {
                if (count == 0) {
                    list.add(String.valueOf(nums[i]));
                } else {
                    String s = nums[cur] + "->" + nums[i];
                    list.add(s);
                }
            }
        }
        return list;
    }
}
