/**
 * @author Ethereal
 * @create 2018-08-27-8:36 AM
 */
public class LC390 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(lastRemaining(9));
        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }
}