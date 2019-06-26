package arrays;

import java.util.ArrayList;
import java.util.List;

public class LC118_PascalTriangle {
    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(list);
        }
        return ret;
    }

    public static void main(String[] args) {
        LC118_PascalTriangle lc118_pascalTriangle = new LC118_PascalTriangle();
        List<List<Integer>> ret = lc118_pascalTriangle.generate(5);
        ret.forEach(list -> list.forEach(System.out::println));
    }
}
