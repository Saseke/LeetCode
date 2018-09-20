public class LC641 {

}

class LinkedNode {
    int val;
    LinkedNode pre;
    LinkedNode next;

    LinkedNode(int val) {
        this.val = val;
    }
}

class MyCircularDeque {

    int length;
    int size;
    LinkedNode first;
    LinkedNode end;

    public MyCircularDeque(int k) {
        length = 0;
        size = k;
    }

    public boolean insertFront(int value) {
        LinkedNode node = new LinkedNode(value);
        if (length == 0) {
            first = node;
            end = node;
        } else {
            node.next = first;
            first.pre = node;
        }
        if (size >= (length + 1)) {
            first = node;
            length++;
            return true;
        } else {
            return false;
        }
    }

    public boolean insertLast(int value) {
        LinkedNode node = new LinkedNode(value);
        if (end == null) {
            first = node;
            end = node;
        } else {
            end.next = node;
            node.pre = end;
        }
        if (size >= (length + 1)) {
            end = node;
            length++;
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteFront() {
        if (length == 0) {
            return false;
        } else if (length == 1) {
            first = null;
            end = null;
            length = 0;
            return true;
        } else {
            first = first.next;
            length--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (length == 0) {
            return false;
        } else if (length == 1) {
            first = null;
            end = null;
            length = 0;
            return true;
        } else {
            end = end.pre;
            length--;
            return true;
        }

    }

    public int getFront() {
        if (length == 0) {
            return -1;
        }
        return first.val;
    }

    public int getRear() {

        if (length == 0) {
            return -1;
        }
        return end.val;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == size;
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        deque.insertFront(1);
        deque.deleteLast();
        deque.getRear();
        deque.getFront();
        deque.getFront();
        deque.deleteFront();
        deque.insertFront(6);
        deque.insertLast(5);
        deque.insertFront(9);
        deque.getFront();
        deque.insertFront(6);
    }
}

