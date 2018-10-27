/**
 * @Author Yoke
 * @Date 2018/10/27 上午9:42
 */
public class LC318 {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < words.length; i++) {
            String curWord = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String cmp = words[j];
                boolean flag = true;
                for (char c : curWord.toCharArray()) {
                    if (cmp.indexOf(c) != -1) {
                        flag = false;
                    }
                }
                if (flag) {
                    int tmp = curWord.length() * cmp.length();
                    if (tmp > ret) {
                        ret = tmp;
                    }
                }
            }
        }
        return ret;
    }

    public static int maxProduct1(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
                    maxProduct = words[i].length() * words[j].length();
            }
        return maxProduct;
    }

    public static void main(String[] args) {
    }
}
