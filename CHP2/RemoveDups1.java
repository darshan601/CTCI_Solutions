package CHP2;

// Remove Dups! Write code to remove duplicates from an unsorted linked list.

// FOLLOW UP
// How would you solve this problem if a temporary buffer is not allowed?

public class RemoveDups1 {

    // check for dups with only one data structure

    public static void checkDups(Node head) {
        Node current = head;

        while (current != null) {
            Node runner = current;

            while (runner.next != null) {

                if (current.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }

            }

            current = current.next;
        }
        System.out.println("\n\nNodes after removing Duplicates");
        head.printNodes(head);
    }

    public static void main(String[] args) {
        Node head = new Node(2);

        head.appendToTail(1);
        head.appendToTail(2);
        head.appendToTail(5);
        head.appendToTail(3);
        head.appendToTail(5);
        head.appendToTail(5);

        head.printNodes(head);
        checkDups(head);
    }
}