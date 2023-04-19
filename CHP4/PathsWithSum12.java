package CHP4;

import java.util.HashMap;

// Paths with Sum: You are given a binary tree in which each node contains an integer value (which
// might be positive or negative). Design an algorithm to count the number of paths that sum to a
// given value. The path does not need to start or end at the root or a leaf, but it must go downwards
// (traveling only from parent nodes to child nodes).

public class PathsWithSum12 {

    public int countPaths(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> sumsDict = new HashMap<Integer, Integer>();
        sumsDict.put(0, 1);
        return countPathHelper(root, 0, targetSum, sumsDict);
    }

    private int countPathHelper(TreeNode node, int runningSum, int targetSum, HashMap<Integer, Integer> sumsDict) {

        if (node == null) {
            return 0;
        }

        runningSum += node.val;

        int count = sumsDict.getOrDefault(runningSum - targetSum, 0);

        if (runningSum == targetSum)
            count += 1;

        sumsDict.put(runningSum, sumsDict.getOrDefault(runningSum, 0) + 1);
        count += countPathHelper(node.left, runningSum, targetSum, sumsDict);
        count += countPathHelper(node.right, runningSum, targetSum, sumsDict);

        sumsDict.put(runningSum, sumsDict.get(runningSum) - 1);

        if (sumsDict.get(runningSum) == 0) {
            sumsDict.remove(runningSum);
        }

        return count;
    }

    public static void main(String[] args) {

        /*
         * 10
         * / \
         * 5 -3
         * / \ \
         * 3 2 11
         * / \
         * 3 -2
         */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(-2);

        int targetSum = 8;
        PathsWithSum12 pathsWithSum = new PathsWithSum12();
        int count = pathsWithSum.countPaths(root, targetSum);
        System.out.println("Number of paths that sum to " + targetSum + ": " + count); // Expected output: 3
    }

}
