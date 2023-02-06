package CHP2;

// Sum Lists: You have two numbers represented by a linked list, where each node contains a single
// digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
// function that adds the two numbers and returns the sum as a linked list.
// EXAMPLE
// Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
// Output: 2 -> 1 -> 9. That is, 912.
// FOLLOW UP
// Suppose the digits are stored in forward order. Repeat the above problem.
// EXAMPLE
// lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
// Output: 9 - > 1 -> 2. That is, 912.

public class SumLists5 {

    public static int returnsum(Node num1) {
        int sum = 0;
        int n = 1;
        while (num1 != null) {
            sum = sum + (num1.data * (n));
            // System.out.println(num1.data + " :num1: " + sum);
            n = n * 10;
            num1 = num1.next;
        }
        // System.out.println(sum);
        return sum;
    }

    public static void sumlist(Node num1, Node num2) {
        int sum = returnsum(num1) + returnsum(num2);

        System.out.println(sum);

        int temp = sum;

        Node n = new Node(-1);
        Node curr = n;
        while (temp > 0) {

            int digit = temp % 10;
            if (n.data == -1) {
                n.data = digit;
            } else {
                curr.next = new Node(digit);
                curr = curr.next;
            }
            temp = temp / 10;

        }

        n.printNodes(n);
    }

    // FOLLOW UP
    public static int returnSum1(Node num1) {
        StringBuilder builder = new StringBuilder();

        while (num1 != null) {
            builder.append(String.valueOf(num1.data));
            num1 = num1.next;
        }
        // System.out.println(builder);
        return Integer.parseInt(builder.toString());
    }

    // FOLLOW UP
    public static void sumList1(Node head1, Node head2) {
        int sum = returnSum1(head1) + returnSum1(head2);

        // System.out.println(sum);

        char[] s = String.valueOf(sum).toCharArray();

        // System.out.println(s);

        Node n = new Node(-1);
        // Node curr=n;
        for (char c : s) {
            if (n.data == -1) {

                n.data = Integer.valueOf(String.valueOf(c));
            } else {
                n.appendToTail(Integer.valueOf(String.valueOf(c)));
            }
        }

        n.printNodes(n);
    }

    public static void main(String args[]) {
        Node head = new Node(6);
        head.appendToTail(1);
        head.appendToTail(7);

        Node head2 = new Node(2);
        head2.appendToTail(9);
        head2.appendToTail(5);

        head.printNodes(head);
        head2.printNodes(head2);

        sumlist(head, head2);
        System.out.println("Follow-UP below");
        // FOLLOWUP
        sumList1(head, head2);
    }
}
