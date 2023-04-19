package CHP3;

// Three in One: Describe how you could use a single array to implement three stacks.

// Algorithm:

// Initialize an array of size k to keep track of the top element of each stack.
// Initialize an array next of size n, where n is the total size of the array that will hold the k stacks. Set the value of next[i] to i+1 for all 0 ≤ i < n-1, and next[n-1] to -1. This array will be used to keep track of the next element in the stack.
// Initialize an array top of size k to store the index of the top element of each stack. Set the value of top[i] to -1 for all 0 ≤ i < k.
// To push an element onto the i-th stack, do the following:
// Check if the array is full by checking if next[0] is -1. If it is, return an error message indicating that the stack is full.
// Set the value of next[0] to top[i].
// Set the value of top[i] to 0.
// Set the value of next[top[i]] to the new element’s index.
// Increment the value of top[i] by the block size.
// To pop an element from the i-th stack, do the following:
// Check if the stack is empty by checking if top[i] is -1. If it is, return an error message indicating that the stack is empty.
// Decrement the value of top[i] by the block size.
// Set the value of next[top[i]] to -1.
// Return the element at the index top[i] + block size – 1.

public class ThreeinOne1 {
    static class KStack {
        int arr[];
        int top[];
        int next[];

        int n, k;
        int free;

        KStack(int k1, int n1) {
            k = k1;
            n = n1;

            arr = new int[n];
            top = new int[k];
            next = new int[n];

            for (int i = 0; i < k; i++) {
                top[i] = -1;
            }

            free = 0;
            for (int i = 0; i < n - 1; i++) {
                next[i] = i + 1;
            }
            next[n - 1] = -1; // -1 is used to indicate end of free list
        }

        boolean isFull() {
            return (free == -1);
        }

        void push(int item, int st_no) {
            if (isFull()) {
                System.out.println("Stack Overflow");
                return;
            }

            int i = free;// Store index of first free slot

            free = next[i];// Update index of free slot to index of next slot in free list

            next[i] = top[st_no];// Update next of top and then top for stack number 'sn'
            top[st_no] = i;

            arr[i] = item;// push into arr
        }

        boolean isEmpty(int st_no) {
            return (top[st_no] == -1);
        }

        int pop(int st_no) {

            if (isEmpty(st_no)) {
                System.out.println("Stack Underflow");
                return Integer.MAX_VALUE;
            }

            int i = top[st_no];//// Find index of top item in stack number 'sn'

            top[st_no] = next[i];// Change top to store next of previous top

            next[i] = free;// Attach the previous top to the beginning of free list
            free = i;

            return arr[i];

        }

    }

    public static void main(String[] args) {
        int k = 3, n = 10;

        KStack ks = new KStack(k, n);

        ks.push(15, 2);
        ks.push(45, 2);

        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }
}
