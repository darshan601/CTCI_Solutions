package CHP3;

// Stack Min: How would you design a stack which, in addition to push and pop, has a function min
// which returns the minimum element? Push, pop and min should all operate in 0(1) time.

public class StackMin2 {
    private static MyStack<Integer> stack;
    private static MyStack<Integer> minStack;

    StackMin2() {
        stack = new MyStack<>();
        minStack = new MyStack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            System.out.println("Error");
        if (stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            System.out.println("Error");
            return -1;
        }
        return stack.peek();

    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackMin2 stackMin2 = new StackMin2();

        stackMin2.push(15);

        stackMin2.push(13);

        stackMin2.push(3);

        stackMin2.push(10);

        System.out.println(stackMin2.getMin());
        System.out.println(stackMin2.top());

    }
}
