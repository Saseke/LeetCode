package arrays;

import static java.lang.Character.getNumericValue;

public class LC67_AddBinary {
    private String addBinaryBetter(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0, sum = 0;
        while (i >= 0 || j >= 0) {
            sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    private String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();  // 得到a,b对应的字符数组
        char[] bChars = b.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int i = aChars.length - 1, j = bChars.length - 1, p = 0, q;  // i,j指向aChars和bChars的最后一个元素,p表示进位数字,q表示每一位最后的结果
        while (i >= 0 && j >= 0) {     // 从最后一位开始，先处理具有相同位数的位置元素
            int tmp = getNumericValue(aChars[i]) + getNumericValue(bChars[j]) + p;
            q = tmp % 2;
            p = tmp > 1 ? 1 : 0;
            stringBuilder.append(q);
            i--;
            j--;
        }
        while (i >= 0) {    // aChars长度大于bChars
            int tmp = getNumericValue(aChars[i]) + p;
            q = tmp % 2;
            p = tmp > 1 ? 1 : 0;
            stringBuilder.append(q);
            i--;
        }
        while (j >= 0) {    // bChars 长度大于aChars
            int tmp = getNumericValue(bChars[j]) + p;
            q = tmp % 2;
            p = tmp > 1 ? 1 : 0;
            stringBuilder.append(q);
            j--;
        }
        if (p != 0) {   // 最后可能产生一个进位
            stringBuilder.append("1");
        }
        return stringBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        LC67_AddBinary lc67_addBinary = new LC67_AddBinary();
        System.out.println(lc67_addBinary.addBinaryBetter("1", "111"));
    }
}
