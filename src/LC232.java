import java.util.Stack;

/**
 * @Author Yoke
 * @Date 7/26/18 1:53 PM
 */
public class LC232 {

}

class MyQueue1 {

    private int[] elementData;

    private int head;
    private int end;


    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Initialize your data structure here.
     */
    public MyQueue1() {
        elementData = new int[DEFAULT_CAPACITY];
        head = end = 0;
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        elementData[end] = x;
        end++;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        int x = elementData[head];
        head++;
        return x;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return elementData[head];
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return end - head == 0;
    }

    public static void main(String[] args) {
        MyQueue1 queue = new MyQueue1();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.empty());
    }
}

class MyQueue2 {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue2() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}