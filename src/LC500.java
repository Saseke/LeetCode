import java.util.ArrayList;
import java.util.List;

public class LC500 {
    public static void main(String[] args) {
        String[] s = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        String[] strings = findWords(s);
        for (String s1 : strings) {
            System.out.println(s1);
        }
    }

    public static String[] findWords(String[] words) {
        List<String> list = new ArrayList();
        for (String s : words) {
            if (find(s)) {
                list.add(s);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static boolean find(String s) {
        String[] keys = {"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
        int index = 0;
        char c = s.charAt(0);
        for (String key : keys) {
            int result = key.indexOf(c);
            if (result != -1) {
                break;
            }
            index++;
        }
        String key = keys[index];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (key.indexOf(ch) == -1) {
                return false;
            }
        }
        return true;
    }
}
