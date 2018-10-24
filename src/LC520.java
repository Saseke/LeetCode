/**
 * @Author Yoke
 * @Date 2018/10/22 上午8:45
 */
public class LC520 {
    public boolean detectCapitalUse(String word) {
        if (word.equals("")) {
            return false;
        } else if (word.length() == 1) {
            return true;
        }
        char[] chars = word.toCharArray();
        int caseFlg;
        if (Character.isLowerCase(chars[0])) {
            caseFlg = 0;
        } else if (Character.isUpperCase(chars[0]) && Character.isUpperCase(chars[1])) {
            caseFlg = 1;
        } else {
            caseFlg = 2;
        }
        switch (caseFlg) {
            case 0: {
                for (int i = 1; i < chars.length; i++) {
                    if (Character.isUpperCase(chars[i])) {
                        return false;
                    }
                }
                return true;
            }
            case 1: {
                for (int i = 2; i < chars.length; i++) {
                    if (Character.isLowerCase(chars[i])) {
                        return false;
                    }
                }
                return true;
            }
            case 2: {
                for (int i = 2; i < chars.length; i++) {
                    if (Character.isUpperCase(chars[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
