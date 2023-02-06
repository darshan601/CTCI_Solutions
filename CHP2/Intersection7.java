package CHP2;

import java.util.ArrayList;

//Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
// node. Note that the intersection is defined based on reference, not value. That is, if the kth
// node of the first linked list is the exact same node (by reference) as the jth node of the second
// linked list, then they are intersecting.

public class Intersection7 {

    public static void checkIntersection(Node n1, Node n2) {

        ArrayList<Node> nodes = new ArrayList<>();

        while (n1 != null) {
            nodes.add(n1);
            n1 = n1.next;
        }
        int flag = 0;
        // check for nodes in array
        while (n2 != null) {
            for (Node node : nodes) {
                if (node == n2) {
                    System.out.println("Intersecting at ----");
                    System.out.println(node.data);
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
            n2 = n2.next;

        }

    }

    public static void main(String args[]) {
        // 1st List
        Node head = new Node(2);

        Node n1 = new Node(3);
        head.next = n1;
        Node n2 = new Node(4);
        n1.next = n2;
        Node n3 = new Node(9);
        n2.next = n3;
        head.printNodes(head);

        // New list
        Node head2 = new Node(0);

        Node k1 = new Node(2);
        head2.next = k1;
        k1.next = head;
        head2.printNodes(head2);

        checkIntersection(head, head2);
    }
}
