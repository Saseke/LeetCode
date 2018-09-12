import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yoke
 * Created on 2018/9/11
 */
public class LC884 {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
    }

    public String[] uncommonFromSentences2(String A, String B) {
        String str = A + " " + B;
        String[] strings = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }

    public String[] uncommonFromSentences1(String A, String B) {
        String[] aWords = getWords(A);
        String[] bWords = getWords(B);
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String s : aWords) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : bWords) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }


    private static String[] getWords(String s) {

        return s.split(" ");
    }
}
