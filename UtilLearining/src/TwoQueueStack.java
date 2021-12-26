import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 */
public class TwoQueueStack {
    public static void main(String[] args) {
        TwoQueueStack TwoQueueStack = new TwoQueueStack();
        TwoQueueStack.push(1);
        TwoQueueStack.push(2);
        TwoQueueStack.push(3);
        TwoQueueStack.push(4);
        System.out.println(TwoQueueStack.top());
        TwoQueueStack.pop();
        System.out.println(TwoQueueStack.top());
    }

    Queue<Integer> queueA = new LinkedList<>();
    Queue<Integer> queueB = new LinkedList<>();

    /**
     * Get the top element.
     */
    public int top() {
        if (queueA.isEmpty() && !queueB.isEmpty()) {
            return queueB.peek();
        }
        return queueA.peek();
    }
    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queueA.isEmpty() && !queueB.isEmpty())
            return queueB.remove();
        return queueA.remove();
    }
    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queueA.isEmpty() && !queueB.isEmpty()) {
            queueA.add(x);
            while (!queueB.isEmpty()){
                int data = queueB.remove();
                queueA.add(data);
            }
        } else if (!queueA.isEmpty() && queueB.isEmpty()) {
            queueB.add(x);
            while (!queueA.isEmpty()){
                int data = queueA.remove();
                queueB.add(data);
            }
        } else if (queueA.isEmpty() && queueB.isEmpty()) {
            queueA.add(x);
        }
    }
}
