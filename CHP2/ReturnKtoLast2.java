package CHP2;

import java.util.HashMap;

// Return Kth to Last: Implement an algorithm to find the kth 
// to last element of a singly linked list.

public class ReturnKtoLast2 {

    // Approach using Dictionary
    public static void findElem(Node head, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        Integer i = 0;

        Node current = head;
        while (current != null) {
            i++;
            hashMap.put(i, Integer.valueOf(current.data));
            current = current.next;
        }
        System.out.println(hashMap);
        // System.out.println(i);
        System.out.println(hashMap.get(i - k));

    }

    // Approach using Double pointer
    public static void findElem1(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i <= k; i++) {
            if (p1 == null) {
                System.out.println("Length Exceeded");
            }
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        System.out.println(p2.data);
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

        findElem1(head, 2);
    }
}
