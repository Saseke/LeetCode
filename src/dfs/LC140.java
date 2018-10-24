package dfs;

import java.util.*;

/**
 * @Author Yoke
 * @Date 2018/10/17 上午8:51
 */
public class LC140 {
    private List<String> ret = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return backtrack2(s, wordDict, new LinkedList<>());
    }

    public List<String> backtrack1(String s, List<String> dict, Stack<String> stack) {
        for (int i = 0; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (dict.contains(str)) {
                stack.push(str);
                backtrack1(s.substring(i), dict, stack);
                if (i == s.length()) {
                    List<String> stackList = new ArrayList<>(stack);
                    StringBuilder s1 = new StringBuilder();
                    for (String s2 : stackList) {
                        s1.append(s2).append(" ");
                    }
                    ret.add(s1.substring(0, s1.length() - 1));
                }
                stack.pop();
            }
        }
        return ret;
    }

    public List<String> backtrack2(String s, List<String> dict, LinkedList<String> linkedList) {
        for (int i = 0; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (dict.contains(str)) {
//                stack.push(str);
                linkedList.add(str);
                backtrack2(s.substring(i), dict, linkedList);
                if (i == s.length()) {
                    StringBuilder s1 = new StringBuilder();
                    for (String s2 : linkedList) {
                        s1.append(s2).append(" ");
                    }
                    ret.add(s1.substring(0, s1.length() - 1));
                }
//                stack.pop();
                linkedList.removeLast();
            }
        }
        return ret;
    }


    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        LinkedList<String> ret = new LinkedList<>();
        if (s.equals("")) {
            ret.add("");
            return ret;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : subList) {
                    ret.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, ret);
        return ret;
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        return DFS(s, new HashSet<>(wordDict), new HashMap<>());
    }

    public static void main(String[] args) {
        LC140 lc140 = new LC140();
        List<String> wordDict = new LinkedList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("appleopen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        String s = "pineapplepenapple";
        List<String> list1 = lc140.wordBreak2(s, wordDict);
    }
}