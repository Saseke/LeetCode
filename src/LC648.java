import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Yoke
 * @Date 2018/10/27 上午9:18
 */
public class LC648 {
    public String replaceWords(List<String> dict, String sentence) {
        if (sentence.equals("")) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (String ds : dict) {
                if (word.startsWith(ds)) {
                    if (map.containsKey(word)) {
                        String oldStr = map.get(word);
                        if (ds.length() < oldStr.length()) {
                            map.put(word, ds);
                        }
                    } else {
                        map.put(word, ds);
                    }
                }
            }
            builder.append(map.getOrDefault(word, word));
            if (i != words.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LC648 lc648 = new LC648();
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String s = "the cattle was rattled by the battery";
        System.out.println(lc648.replaceWords(dict, s));
    }
}
