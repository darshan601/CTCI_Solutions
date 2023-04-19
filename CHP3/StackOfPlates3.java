package CHP3;

import java.util.ArrayList;
import java.util.Stack;

public class StackOfPlates3 {
    private int capacity;

    private ArrayList<Stack<Integer>> stacks;

    public StackOfPlates3(int capacity) {
        this.capacity = capacity;
        this.stacks = new ArrayList<>();

    }

    private Stack<Integer> getLastStack() {
        if (this.stacks.isEmpty()) {
            System.out.println("Empty");
            return null;

        }
        return stacks.get(stacks.size() - 1);
    }

    public void push(int x) {

        Stack<Integer> lastStack = getLastStack();
        if (lastStack != null && !(lastStack.size() == capacity)) {
            lastStack.push(x);
            System.out.println("pushed");
        } else {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(x);
            stacks.add(newStack);
            System.out.println("new Stack added - pushed");
        }
    }

    public int pop() {

        Stack<Integer> lStack = getLastStack();
        if (lStack == null || lStack.isEmpty()) {
            System.out.println("Set of Stack is empty");
        }
        int val = lStack.pop();
        if (lStack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
            System.out.println("popped");
        }
        System.out.println(val);
        return val;
    }

    public int peek1() {
        Stack<Integer> lastStack = getLastStack();
        if (lastStack == null || lastStack.isEmpty()) {
            System.out.println("Set of Stacks is Empty");
            throw new RuntimeException();

        }
        System.out.println(lastStack.peek());
        return lastStack.peek();
    }

    public int popAt(int index) {
        if (index < 0 || index >= stacks.size()) {
            throw new RuntimeException("Invalid sub-stack size");
        }
        Stack<Integer> subStack = stacks.get(index);

        if (subStack.isEmpty()) {
            throw new RuntimeException("SubStack is empty");
        }
        int val = subStack.pop();

        // shift elements from next substack to fill the gap
        for (int i = index + 1; i < stacks.size(); i++) {
            Stack<Integer> nexStack = stacks.get(i);
            int bottom = nexStack.remove(0);
            subStack.push(bottom);
            subStack = nexStack;
        }
        if (subStack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        System.out.println("pop At : val" + val);
        return val;
    }

    public static void main(String[] args) {
        StackOfPlates3 stackOfPlates3 = new StackOfPlates3(3);

        stackOfPlates3.push(1);
        stackOfPlates3.push(2);
        stackOfPlates3.push(3);
        stackOfPlates3.push(0);
        stackOfPlates3.push(10);

        stackOfPlates3.peek1();
        stackOfPlates3.pop();
        stackOfPlates3.pop();
        stackOfPlates3.popAt(0);
        stackOfPlates3.peek1();
    }
}
