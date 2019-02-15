package ccf;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author Yoke
 * @Date 2019/02/15 下午5:55
 */
public class IntermediateNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int next = scanner.nextInt();
            set.add(next);
        }
        int size = set.size();
        if (size % 2 == 0) {
            System.out.println(-1);
        } else {
            Iterator iterator = set.iterator();
            int i = 1;
            while (iterator.hasNext()) {
                if (i++ == size) {
                    System.out.println(iterator.next());
                }
            }
        }
    }
}
