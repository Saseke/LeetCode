/**
 * @author ethereal
 * @since 2018-09-04 7:21 AM
 */
public class LC876 {

    public static void main(String[] args) {

    }

    /**
     * spend 1ms
     * use a fast pointer and a slow pointer
     *
     * @param head ListNode of head
     */
    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * spend 3ms
     * method 1: first traversal to get depth,then traversal half of the linked list
     *
     * @param head ListNode of head
     */
    public static ListNode middleNode1(ListNode head) {
        int depth = depth(head);
        ListNode ret = head;
        int num = 0;
        if (depth == 0) {
            return null;
        } else {
            int middle = depth / 2 + 1;
            while (num <= middle) {
                ret = ret.next;
                num++;
            }
        }
        return ret;
    }

    private static int depth(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
