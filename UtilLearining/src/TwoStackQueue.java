import java.util.Stack;

/**
 * 两个栈实现一个队列
 */
public class TwoStackQueue {
    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.appendTail(1);
        twoStackQueue.appendTail(2);
        twoStackQueue.appendTail(3);
        System.out.println(twoStackQueue.deleteHead());
        System.out.println(twoStackQueue.deleteHead());
        System.out.println(twoStackQueue.deleteHead());
    }
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public TwoStackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public  void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}
