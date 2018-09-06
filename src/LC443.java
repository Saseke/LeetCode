/**
 * @author ethereal
 * @since 2018-09-02 8:06 PM
 */
public class LC443 {
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(chars));
    }

    private static int compress(char[] chars) {
        //  read of cursor, write of cursor,cur anchor
        int read, write = 0, anchor = 0;
        for (read = 0; read < chars.length; read++) {
            if ((read + 1) == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
}
