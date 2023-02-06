package CHP2;

// Palindrome: Implement a function to check if a linked list is a palindrome.

public class Palindrome6 {

    public static void checkPalindrome(Node head) {
        StringBuilder builder = new StringBuilder();

        int count = 1;
        int sum = 0;

        while (head != null) {
            builder.append(String.valueOf(head.data));

            sum = sum + (head.data * (count));

            count = count * 10;

            head = head.next;
        }
        System.out.println(Integer.valueOf(builder.toString()));
        System.out.println(sum);
        if (Integer.valueOf(builder.toString()) == sum) {
            System.out.println("Palindrome");
        } else
            System.out.println("not a Palindrome");
    }

    public static void main(String args[]) {
        Node head = new Node(2);

        head.appendToTail(1);
        head.appendToTail(0);
        head.appendToTail(1);
        head.appendToTail(0);

        head.printNodes(head);

        checkPalindrome(head);
    }
}
