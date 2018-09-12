import java.util.ArrayList;
import java.util.List;

public class LC491 {

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 6, 7, 7, 3 };
		System.out.println(findSubsequences(nums));
	}

	public static List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
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
