/**
 * @author Yoke
 * Created on 2018/8/6
 */
public class LC345 {

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

    private static String reverseVowels(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                builder.append(c);
            }
        }
        builder.reverse();
        StringBuilder stringBuilder = new StringBuilder(s);
        int index = 0, curPoint = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                stringBuilder.setCharAt(index, builder.charAt(curPoint));
                curPoint++;
            }
            index++;
        }
        return stringBuilder.toString();
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
