class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{-19, -46, -19, -46, -9, -9, -19, 17, 17, 17, -13, -13, -9, -13, -46, -28};
        System.out.println(singleNumber(nums));
        System.out.println(~2);
    }

    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i : nums) {
            ones = (ones ^ i) & ~twos;
            twos = (twos ^ i) & ~ones;
        }
        return ones;
    }
}