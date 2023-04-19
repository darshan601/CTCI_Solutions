package CHP4;

// Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
// to create a binary search tree with minimal height.

// Follow the steps mentioned below to implement the approach:

// Set The middle element of the array as root.
// Recursively do the same for the left half and right half.
// Get the middle of the left half and make it the left child of the root created in step 1.
// Get the middle of the right half and make it the right child of the root created in step 1.
// Print the preorder of the tree.

public class MinimalTree2 {

    static Node root;

    Node sortedArrayToBST(int arr[], int start, int end) {
        // base case
        if (start > end) {
            return null;
        }

        // get middle element and make it root
        int mid = (start + end) / 2;

        Node node = new Node(arr[mid]);

        // Recrusive for left subtree
        node.left = sortedArrayToBST(arr, start, mid - 1);

        // recursive for right subtree
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;

    }

    // print preorder
    void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        MinimalTree2 tree = new MinimalTree2();

        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

        int n = arr.length;

        root = tree.sortedArrayToBST(arr, 0, n - 1);

        System.out.println("Preorder -----");

        tree.preorder(root);
    }

}
