package CHP2;

public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    // Append to Tail
    void appendToTail(int d) {

        Node end = new Node(d);
        Node n = this;

        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    // Delete the Node
    Node delNode(Node head, int d) {
        Node n = head;

        // moved head
        if (n.data == d) {
            return head.next;
        }

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                // head didn't change
                return head;
            }
            n = n.next;
        }
        return head;
    }

    // Print LinnkedList
    void printNodes(Node head) {
        Node n = head;
        while (n.next != null) {

            System.out.print(n.data);
            System.out.print(" -> ");

            n = n.next;
        }
        System.out.println(n.data);
    }
}
