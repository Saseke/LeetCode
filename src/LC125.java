import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/10/12 上午8:34
 */
public class LC125 {
    public boolean isPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        List<Character> list = new ArrayList<>();
        String[] strings = s.split(" ");
        for (String str : strings) {
            for (Character c : str.toCharArray()) {
                if (Character.isLetter(c) || Character.isDigit(c)) {
                    list.add(Character.toLowerCase(c));
                }
            }
        }
        int p = 0, q = list.size() - 1;
        while (p <= q) {
            if (list.get(p) != list.get(q)) {
                return false;
            }
            p++;
            q--;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        List<Character> list = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                list.add(Character.toLowerCase(c));
            }
        }
        int p = 0, q = list.size() - 1;
        while (p <= q) {
            if (list.get(p) != list.get(q)) {
                return false;
            }
            p++;
            q--;
        }
        return true;
    }

    public static void main(String[] args) {
        LC125 lc125 = new LC125();
        System.out.println(Character.toLowerCase(10));
        System.out.println(lc125.isPalindrome1("0P"));
    }
}
