package CHP3;

import java.util.Stack;

// Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.

public class QueueViaStacks4 {
    Stack<Integer> Enqueue;
    Stack<Integer> Dequeue;

    QueueViaStacks4() {
        Enqueue = new Stack<>();
        Dequeue = new Stack<>();
    }

    public void Enqueue1(int x) {
        if (Dequeue.size() > 0) {
            int size = Dequeue.size();
            for (int i = 0; i < size; i++) {
                int temp = Dequeue.pop();
                Enqueue.push(temp);
            }
        }
        Enqueue.push(x);
    }

    public int Dequeue1() {
        if (Enqueue.isEmpty()) {
            throw new RuntimeException("Empty Queue");
        }
        if (Dequeue.size() > 0) {
            return Dequeue.pop();
        } else {
            int size = Enqueue.size();
            for (int i = 0; i < size; i++) {
                int temp = Enqueue.pop();
                Dequeue.push(temp);
            }
            return Dequeue.pop();
        }
    }

    public static void main(String[] args) {
        QueueViaStacks4 q = new QueueViaStacks4();
        // q.Dequeue1();

        q.Enqueue1(10);
        q.Enqueue1(20);
        q.Enqueue1(30);
        q.Dequeue1();
        q.Enqueue1(40);

        System.out.println(q.Enqueue);
    }
}
