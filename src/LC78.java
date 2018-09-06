import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ethereal
 * @since 2018-09-01 8:39 AM
 */
public class LC78 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        subsets(arr);
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
