/**
 * @Author Yoke
 * @Date 2018/11/18 上午10:58
 */
public class LC944 {
    public static void main(String[] args) {
        LC944 lc944 = new LC944();
        String[] strings = new String[]{"zyx", "wvu", "tsr"};

        System.out.println(lc944.minDeletionSize(strings));
    }

    public int minDeletionSize(String[] A) {
        int res = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length; j++) {
                if (j + 1 < A.length) {
                    if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
