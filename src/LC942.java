/**
 * @Author Yoke
 * @Date 2018/11/18 上午11:11
 */
public class LC942 {

    public static void main(String[] args) {
        LC942 lc942 = new LC942();
        lc942.diStringMatch("IDID");
    }

    public int[] diStringMatch(String S) {
        int[] ret = new int[S.length() + 1];
        ret[0] = 10;
        int index = 0;
        if (S.equals("")) {
            return ret;
        }
        for (int i = 0; i < S.length(); i++) {
            int tmp = ret[index];
            if (index == S.length()) {
                break;
            }
            if (S.charAt(i) == 'I') {
                ret[++index] = tmp + 1;
            } else {
                ret[++index] = tmp - 1;
            }
        }
        return ret;
    }
}
