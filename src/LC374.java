public class LC374 {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;   // 如果写成(start+end)/2有溢出的风险
            int guessRet = guess(mid);
            if (guessRet == 0) {
                return mid;
            } else if (guessRet == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // 题中自动给出
    public int guess(int num) {
        return 0;
    }
}
