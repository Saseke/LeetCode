/**
 * no result
 * @Author Yoke
 * @Date 7/20/18 11:22 PM
 */
public class LC767 {

    public static void main(String[] args) {
        String s = "bfrbs";
        System.out.println(reorganizeString(s));
    }

    public static String reorganizeString(String s) {
        char[] chars = s.toCharArray();
        char multiChar = 0;
        int count = 1;
        int totalCount = 0;
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            char indexChar = chars[i];
            if ((i + 1) < chars.length) {
                char indexNextChar = chars[i + 1];
                if (indexChar == indexNextChar) {
                    multiChar = indexChar;
                    flag = true;
                    count++;
                    totalCount++;
                } else if (indexChar == multiChar) {
                    totalCount++;
                } else {
                    stringBuilder.append(indexChar);
                }
            } else if (indexChar == multiChar) {
                totalCount++;
            } else {
                stringBuilder.append(indexChar);
            }
        }
        if (flag) {
            if (!judge(count, s)) {
                return "";
            } else if (!judge(totalCount, s)) {
                return "";
            } else {
                int con = 0;
                for (int i = 0; i < stringBuilder.length() + 1; i = i + 2) {
                    if (con <= count) {
                        stringBuilder.insert(i, multiChar);
                        con++;
                    } else {
                        break;
                    }
                }
                return stringBuilder.toString();
            }
        }
        return s;
    }

    public static boolean judge(int count, String s) {
        int length = s.length();
        boolean b = s.length() % 2 == 1;
        if (b && count <= length / 2 + 1) {
            return true;
        } else return s.length() % 2 == 0 && count < length / 2 + 1;
    }
}
