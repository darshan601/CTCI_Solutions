package CHP3;

import java.util.Stack;

// Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
// an additional temporary stack, but you may not copy the elements into any other data structure
// (such as an array). The stack supports the following operations: push, pop, peek, and is Empty.

public class SortStack5 {

    public static void SortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);

        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        SortStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
