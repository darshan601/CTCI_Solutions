package CHP2;

// Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
// the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
// that node.
// EXAMPLE
// lnput:the node c from the linked lista->b->c->d->e->f
// Result: nothing is returned, but the new linked list looks like a->b->d->e- >f

public class DelMiddleNode3 {
    public static void DelNode(Node head, int d) {
        Node current = head;
        while (current.next != null) {
            if (current.next.data == d) {
                current.next = current.next.next;
                break;
            } else {
                current = current.next;
            }

        }
        head.printNodes(head);
    }

    public static void main(String[] args) {
        Node head = new Node(0);

        head.appendToTail(1);
        head.appendToTail(2);
        head.appendToTail(5);
        head.appendToTail(3);
        head.appendToTail(5);
        head.appendToTail(5);

        head.printNodes(head);

        DelNode(head, 5);
        DelNode(head, 5);
    }
}
