package CHP2;

// Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
// before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
// to be after the elements less than x (see below). The partition element x can appear anywhere in the
// "right partition"; it does not need to appear between the left and right partitions.
// EXAMPLE
// Input:
// Output:
// 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
// 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8

public class Partition4 {
    public static void create_partition(Node head, int d) {

        Node higher = new Node(-1);
        Node smaller = new Node(-1);
        Node curr1 = higher;
        Node curr2 = smaller;
        while (head != null) {
            if (head.data >= d) {
                if (higher.data == -1) {
                    higher.data = head.data;
                    curr1 = higher;
                } else {
                    curr1.next = new Node(head.data);
                    curr1 = curr1.next;
                }
            } else {
                if (smaller.data == -1) {
                    smaller.data = head.data;
                    curr2 = smaller;
                } else {
                    curr2.next = new Node(head.data);
                    curr2 = curr2.next;
                }
            }
            head = head.next;
        }
        // System.out.println(smaller.data);
        higher.printNodes(higher);
        smaller.printNodes(smaller);

        // pointing higher linkedlist to small.next
        curr2.next = higher;
        curr1.next = null;

        smaller.printNodes(smaller);
    }

    public static void main(String args[]) {
        Node head = new Node(0);

        head.appendToTail(1);
        head.appendToTail(2);
        head.appendToTail(10);
        head.appendToTail(9);
        head.appendToTail(5);
        head.appendToTail(3);

        head.printNodes(head);

        create_partition(head, 8);
    }
}
