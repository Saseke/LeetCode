package dp.kadane;

/**
 * @Author Yoke
 * @Date 2018/11/29 下午9:42
 */
public class LC121 {
    public int maxProfit(int[] prices) {
        int curMaxPrice = 0, maxPrice = 0;
        for (int i = 1; i < prices.length; i++) {
            curMaxPrice = Math.max(0, curMaxPrice + (prices[i] - prices[i - 1]));
            maxPrice = Math.max(maxPrice, curMaxPrice);
        }
        return maxPrice;
    }

    public static void main(String[] args) {
        LC121 lc121 = new LC121();
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(lc121.maxProfit(arr));
    }
}
