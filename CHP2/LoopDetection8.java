package CHP2;

import java.util.ArrayList;

public class LoopDetection8 {

    public static void detectLoop(Node head) {

        ArrayList<Node> aList = new ArrayList<>();

        int flag = 0;

        while (head != null) {

            for (Node node : aList) {
                if (node == head) {
                    flag = 1;
                    break;
                }
            }

            aList.add(head);

            if (flag == 1) {
                System.out.println("Loop Detected at " + head.data);
                break;
            }

            head = head.next;
        }
        System.out.println("No loop ");
    }

    public static void main(String args[]) {
        Node head = new Node(2);

        Node n1 = new Node(3);
        head.next = n1;

        Node n2 = new Node(4);
        n1.next = n2;

        Node n3 = new Node(9);
        n2.next = n3;

        head.printNodes(head);

        detectLoop(head);
    }

}
