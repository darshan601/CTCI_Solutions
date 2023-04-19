package CHP4;

// Random Node: You are implementing a binary tree class from scratch which, in addition to
// insert, find, and delete, has a method getRandomNode() which returns a random node
// from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
// for getRandomNode, and explain how you would implement the rest of the methods.

public class RandomNode11 {

    static class Node1 {
        int data;
        int children;
        Node1 left, right;
    }

    static Node1 newNode(int data) {
        Node1 temp = new Node1();
        temp.data = data;
        temp.left = temp.right = null;
        temp.children = 0;
        return temp;
    }

    // This is used to fill children counts.
    static int getElements(Node1 root) {
        if (root == null) {
            return 0;
        }
        return getElements(root.left) + getElements(root.right) + 1;
    }

    // Inserts Children count for each node
    static Node1 insertChildrenCountNode(Node1 root) {

        if (root == null) {
            return null;
        }

        root.children = getElements(root) - 1;

        root.left = insertChildrenCountNode(root.left);
        root.right = insertChildrenCountNode(root.right);

        return root;

    }

    // returns number of children for root
    static int children(Node1 root) {
        if (root == null)
            return 0;

        return root.children + 1;
    }

    static int randomNodeUtil(Node1 root, int count) {

        if (root == null) {
            return 0;
        }

        if (count == children(root.left)) {
            return root.data;
        }

        if (count < children(root.left)) {
            return randomNodeUtil(root.left, count);
        }

        return randomNodeUtil(root.right, count - children(root.left) - 1);
    }

    static int randomNode(Node1 root) {
        int count = (int) Math.random() * (root.children + 1);
        return randomNodeUtil(root, count);
    }

    public static void main(String[] args) {
        Node1 root = newNode(10);
        root.left = newNode(20);
        root.right = newNode(30);
        root.left.left = newNode(40);
        root.left.right = newNode(50);
        root.right.left = newNode(60);
        root.right.right = newNode(70);

        insertChildrenCountNode(root);

        System.out.println("A random node from tree " + randomNode(root));
    }
}
