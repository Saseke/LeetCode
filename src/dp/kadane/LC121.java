package dp.kadane;

/**
 * @Author Yoke
 * @Date 2018/11/29 下午9:42
 */

/**
 * 这个求最大收益
 * arr = [a0,a1,a2,a3,a4,a5,a6]
 * areal = [b0,b1,b2,b3,b4,b5,b6]
 * b3 = a3-a2;
 * b4 = a4 -a3
 * b5 = a5 - a4
 * b6 = a6 - a5
 * b3+b4+b5+b6 = a6-a2   求最大收益实际就是求ai-aj的最大值,归根结底还是求连续序列的最大子段和
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
