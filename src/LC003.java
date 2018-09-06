import java.util.*;

/**
 * @author Yoke
 * @Date 7/7/18 8:07 PM
 */
public class LC003 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring4("bcdasa"));
    }


    public static int lengthOfLongestSubstring4(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)) + 1, j);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }


    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    public static int lengthOfLongestSubstring2(String s) {
        int count = 0;
        int precount = 0;
        StringBuilder temp = new StringBuilder();
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = (char) s.getBytes()[i];
            if (temp.length() == 0) {
                temp.append(c);
                precount++;
            } else {
                boolean flag = false;
                int j;
                for (j = 0; j < temp.length(); j++) {
                    char tempc = (char) temp.toString().getBytes()[j];
                    if (tempc == c) {
                        flag = true;
                        if (precount > count) {
                            count = precount;
                        }
                        precount = 0;
                        break;
                    }
                }
                if (flag) {
                    temp = new StringBuilder(temp.substring(j + 1)).append(c);
                    precount = temp.length();
                } else {
                    precount++;
                    temp.append(c);
                }
            }
        }
        if (precount > count) count = precount;
        return count;
    }

    // 超时之作
    public static int lengthOfLongestSubstring(String s) {
        List<Integer> list = new ArrayList<Integer>();
        int count = 0;
        StringBuilder temp = new StringBuilder();
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = (char) s.getBytes()[i];
            if (temp.length() == 0) {
                temp.append(c);
                count++;
            } else {
                boolean flag = false;
                int j;
                for (j = 0; j < temp.length(); j++) {
                    char tempc = (char) temp.toString().getBytes()[j];
                    if (tempc == c) {
                        flag = true;
                        list.add(count);
                        count = 0;
                        break;
                    }
                }
                if (flag) {
                    temp = new StringBuilder(temp.substring(j + 1)).append(c);
                    count = temp.length();
                } else {
                    count++;
                    temp.append(c);
                }
            }
        }
        list.add(count);
        return list.stream().max(Integer::compareTo).get();
    }
}

class test {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.substring(1));

    }
}