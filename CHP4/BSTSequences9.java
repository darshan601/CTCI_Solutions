package CHP4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// BST Sequences: A binary search tree was created by traversing through an array from left to right
// and inserting each element. Given a binary search tree with distinct elements, print all possible
// arrays that could have led to this tree.
// EXAMPLE
// Input:2->1
// 2->3
// Output: {2, 1, 3}, {2, 3, 1}

public class BSTSequences9 {

    public static List<List<Integer>> bstSequences(TreeNode root) {
        List<List<Integer>> sequences = new ArrayList<>();

        if (root == null) {
            sequences.add(new ArrayList<>());
            return sequences;
        }

        List<List<Integer>> leftSequences = bstSequences(root.left);

        List<List<Integer>> rightSequences = bstSequences(root.right);

        LinkedList<Integer> prefix = new LinkedList<>();

        prefix.add(root.val);

        for (List<Integer> leftSeq : leftSequences) {

            for (List<Integer> rightSeq : rightSequences) {

                List<List<Integer>> weaved = new ArrayList<>();

                weaveLists(leftSeq, rightSeq, weaved, prefix);

                sequences.addAll(weaved);

            }

        }

        return sequences;
    }

    private static void weaveLists(List<Integer> first, List<Integer> second, List<List<Integer>> results,
            List<Integer> prefix) {

        if (first.isEmpty() || second.isEmpty()) {
            List<Integer> result = new ArrayList<>(prefix);
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.remove(0);
        prefix.add(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.remove(prefix.size() - 1);
        first.add(0, headFirst);

        int headSecond = second.remove(0);
        prefix.add(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.remove(prefix.size() - 1);
        second.add(0, headSecond);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        List<List<Integer>> sequences = bstSequences(root);

        for (List<Integer> seq : sequences) {
            System.out.println(seq);
        }
    }

}
