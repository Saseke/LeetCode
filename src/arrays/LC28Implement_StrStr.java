package arrays;

public class LC28Implement_StrStr {
    public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }

    public int strStr1(String haystack, String needle) {
        int len = needle.length();
        if (needle.length() == 0) {
            return 0;
        }

        String temp;
        for (int i = 0; i + len <= haystack.length(); i++) {
            temp = haystack.substring(i, i + len);
            if (temp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC28Implement_StrStr lc28Implement_strStr = new LC28Implement_StrStr();
        System.out.println(lc28Implement_strStr.strStr1("a", "a"));
    }

}
