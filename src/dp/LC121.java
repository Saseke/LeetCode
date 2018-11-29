package dp;

/**
 * @Author Yoke
 * @Date 2018/11/20 下午9:19
 */
public class LC121 {
    /**
     * O(n)
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int minValue = prices[0];
        for (int curValue : prices) {
            minValue = Math.min(minValue, curValue);
            maxProfit = Math.max(maxProfit, curValue - minValue);
        }
        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur + (prices[i] - prices[i - 1]));
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        LC121 lc121 = new LC121();
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        lc121.maxProfit1(arr);
//     price = {7}
//     maxValue = 0
//        price = {7,1}
//      maxValue = max(0,0+(1-7))=0
//        price = {7,1,5}
//
    }
}
