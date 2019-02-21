package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2019/02/21 下午3:36
 */
public class PlusOne {

    public int[] plusOne1(int[] digits) {
        if (digits.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            list.add(digits[i]);
        }
        int carry = 1;
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + carry);
            if (list.get(i) == 10) {
                carry = 1;
                list.set(i, 0);
            } else {
                carry = 0;
            }
        }
        if (list.get(list.size() - 1) == 0) {
            list.add(1);
        }
        int[] ret = new int[list.size()];
        for (int i = ret.length - 1; i >= 0; i--) {
            ret[i] = list.get(ret.length - 1 - i);
        }
        return ret;
    }


    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] a1 = {};
        int[] a2 = {9, 9};
        int[] a3 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        int[] ret = plusOne.plusOne2(a2);
        for (int i : ret) {
            System.out.println(i);
        }

    }

}
