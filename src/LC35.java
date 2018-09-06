public class LC35 {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3};
        System.out.println(searchInsert(nums, 2));
    }

    private static int searchInsert(int[] nums, int target) {
        return searchInsert(nums, 0, nums.length - 1, target);
    }

    private static int searchInsert(int[] nums, int start, int end, int target) {
        if (nums == null) {
            return 0;
        }
        if (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return searchInsert(nums, mid + 1, end, target);
            } else {
                return searchInsert(nums, start, mid - 1, target);
            }
        }
        return start;
    }
}
