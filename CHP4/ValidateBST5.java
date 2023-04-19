package CHP4;

import java.util.ArrayList;

// Validate BST: Implement a function to check if a binary tree is a binary search tree.

public class ValidateBST5 {

    static ArrayList<Integer> inorder_node;

    ValidateBST5() {
        inorder_node = new ArrayList<Integer>();
    }

    TreeNode Inorder(TreeNode root) {
        if (root == null)
            return null;

        Inorder(root.left);

        inorder_node.add(root.val);

        Inorder(root.right);

        return root;

    }

    boolean check_ascending(TreeNode root) {
        Inorder(root);

        for (int i = 0; i < inorder_node.size() - 1; i++) {
            if (inorder_node.get(i) < inorder_node.get(i + 1)) {
                System.out.println("Invalid BST");
                return false;
            }
        }

        System.out.println("BST");
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        ValidateBST5 bst = new ValidateBST5();
        bst.check_ascending(root);
    }
}
