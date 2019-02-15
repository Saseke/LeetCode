import java.util.HashMap;
import java.util.Map;

/**
 * @Author Yoke
 * @Date 2019/01/31 上午10:25
 */
public class LC290 {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<java.io.Serializable, Integer> index = new HashMap<java.io.Serializable, Integer>();
        for (Integer i = 0; i < words.length; ++i) {
            Integer left = index.put(pattern.charAt(i), i);
            Integer right = index.put(words[i], i);
            if (left != right) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.put("1", "test"));
        System.out.println(map.put("1", "dsd"));
    }
}
