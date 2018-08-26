import java.util.*;

public class LC819 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String paragraph = "Bob. hIt, ball";
        String[] banned = new String[]{"bob", "hit"};
        System.out.println(mostCommonWord3(paragraph, banned));
        System.out.println(System.currentTimeMillis() - startTime + "ms");
    }

    /**
     * LeetCode spends 7ms,Local spends 0ms
     * method: traversing the string of char array,using Character.isLetter() method determine if end of a word
     * stores per word by using StringBuilder class
     *
     * @param paragraph string to statistics word number
     * @param banned    prohibited strings
     * @return the most frequently occurring of word
     */
    private static String mostCommonWord3(String paragraph, String[] banned) {
        paragraph += ".";  // handle last loop
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String freWord = "";
        Integer max = 0;
        StringBuilder builder = new StringBuilder();
        for (char word : paragraph.toCharArray()) {
            if (Character.isLetter(word)) {
                builder.append(Character.toLowerCase(word));
            } else if (builder.length() > 0) {
                String finalStr = builder.toString();
                if (!set.contains(finalStr)) {
                    map.put(finalStr, map.getOrDefault(finalStr, 0) + 1);
                    Integer count = map.get(finalStr);
                    if (count > max) {
                        max = count;
                        freWord = finalStr;
                    }
                }
                builder.delete(0, builder.length());
            }
        }
        return freWord;
    }


    /**
     * LeetCode spends 19 ms,Local spends 15ms
     * count the number of words,split paragraph to string array,
     * determine if the last symbol is a characterSet can improve effective when you determine
     * if a string is in a array of string
     *
     * @param paragraph string to statistics word number
     * @param banned    prohibited strings
     * @return the most frequently occurring of word
     */
    private static String mostCommonWord2(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) {
            return null;
        }
        String freWord = "";
        Integer max = 0;
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.split(" ");
        for (String word : words) {
            if (!Character.isLetter(word.charAt(word.length() - 1))) {
                word = word.substring(0, word.length() - 1);
            }
            String lowerStr = word.toLowerCase();
            if (set.contains(lowerStr)) {
                continue;
            }
            map.put(lowerStr, map.getOrDefault(lowerStr, 0) + 1);
            Integer count = map.get(lowerStr);
            if (count > max) {
                max = count;
                freWord = lowerStr;
            }
        }
        return freWord;
    }

    /**
     * LeetCode spends 74 ms,Local spends 53ms
     * split string to an array of string,it has some small problem,the space becomes ""
     * <p>method:</p>using  map of key store strings that is split from a string, using  map of value stores
     * string time,then decorate the map collection with a List collection to achieve the purpose of sorting
     * by string time
     *
     * @param paragraph string to statistics word number
     * @param banned    prohibited strings
     * @return the most frequently occurring of word
     */
    private static String mostCommonWord1(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        String[] split = paragraph.split("[!?',;. ]");
        for (String s : split) {
            if (s.equals("")) {
                continue;
            }
            String sLower = s.toLowerCase();
            map.putIfAbsent(sLower, 0);
            map.put(sLower, map.get(sLower) + 1);
        }
        for (String banStr : banned) {
            map.remove(banStr);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(((o1, o2) -> -(o1.getValue() - o2.getValue())));
        return list.get(0).getKey();
    }
}
