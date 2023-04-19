package CHP4;

import java.util.ArrayList;
import java.util.LinkedList;

// List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
// at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).

public class ListofDepth3 {

    public static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> list = null;

        if (lists.size() == level) {
            list = new LinkedList<TreeNode>();

            lists.add(list);

        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    public static ArrayList<LinkedList<TreeNode>> createLinkedList(TreeNode root) {

        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();

        createLevelLinkedList(root, lists, 0);

        return lists;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<LinkedList<TreeNode>> result = createLinkedList(root);

        for (int i = 0; i < result.size(); i++) {
            System.out.print("Depth " + i + ": ");

            for (TreeNode node : result.get(i)) {
                System.out.print(node.val + " ");
            }

            System.out.println();
        }
    }

}
