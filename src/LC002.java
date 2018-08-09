/**
 * @author Yoke
 * @Date 6/28/18 4:59 PM
 */
public class LC002 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(0);
        addTwoNumbers(l1, l2);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode cur = node;
        // 先考虑l1,l2都存在数位的时候
        while ((l1 != null) && (l2 != null)) {
            // 由于可能有进位，所以需要加上cur.val
            cur.val = cur.val + l1.val + l2.val;
            // 如果相加后,cur.val大于9,就进位
            if (cur.val > 9) {
                cur.val = cur.val % 10;
                cur.next = new ListNode(1);
            } else {
                // 由于没有进位时，需要考虑是否需要下一位数,判断一下
                if ((l1.next == null) && (l2.next == null)) {
                    cur.next = null;
                } else {
                    cur.next = new ListNode(0);
                }
            }
         l1 = l1.next;
         l2 = l2.next;
         cur = cur.next;
        }
        // l1有位没有运算时的操作
        cur = getListNode(l1, cur);
        // l2有位数没有运算时的操作
        cur = getListNode(l2, cur);
        return node;
    }

    private static ListNode getListNode(ListNode l, ListNode cur) {
        while (l != null) {
            cur.val = cur.val + l.val;
            if (cur.val > 9) {
                cur.val = cur.val % 10;
                cur.next = new ListNode(1);
           } else {
                if (l.next != null) {
                    cur.next = new ListNode(0);
                }
            }
            l = l.next;
            cur = cur.next;
        }
        return cur;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
