package CHP4;

import java.util.ArrayList;

// Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
// binary search tree. You may assume that each node has a link to its parent.

public class Successor6 {
    // void TraverseTree(TreeNode root, Integer val) {
    // if (root == null) {
    // return;
    // }

    // if ((root.left.val == val) || (root.right.val == val)) {
    // System.out.println("next node according to inorder " + root.val);
    // }
    // TraverseTree(root.left, val);
    // TraverseTree(root.right, val);

    // }

    // using inorder traversel
    void find_next(ValidateBST5 v, TreeNode root, Integer val) {
        v.Inorder(root);
        ArrayList<Integer> node = ValidateBST5.inorder_node;

        for (int i = 0; i < node.size() - 1; i++) {
            if (node.get(i) == val) {
                System.out.println(node.get(i + 1));
                break;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        ValidateBST5 v = new ValidateBST5();
        Successor6 s = new Successor6();

        s.find_next(v, root, 1);
    }
}
