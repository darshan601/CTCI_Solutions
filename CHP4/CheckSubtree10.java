package CHP4;

// Check Subtree: Tl and node2 are two very large binary trees, with Tl much bigger than node2. Create an
// algorithm to determine if node2 is a subtree of Tl.
// A tree node2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to node2.
// That is, if you cut off the tree at node n, the two trees would be identical.

public class CheckSubtree10 {

    static boolean isSubtree(TreeNode node1, TreeNode node2) {

        if (node2 == null) {
            return true; // empty subtree is always a subtree
        }
        if (node1 == null) {
            return false; // base case - we have reached the end of node1 but haven't found a match
        }
        System.out.println(node2.val + " " + node1.val);
        if (node1.val == node2.val && matchTree(node1, node2)) {
            System.out.println("It's Subtree at " + node1.val);
            return true;
        }
        // isSubtree(node1.left, node2);
        // isSubtree(node1.right, node2);

        return isSubtree(node1.left, node2) || isSubtree(node1.right, node2);
    }

    static boolean matchTree(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            System.out.println("both are null");
            return true; // both trees are empty - matches trivially
        }
        if (node1 == null || node2 == null) {
            System.out.println("anyone is null");
            return false; // one of the trees is empty - no match
        }
        System.out.println("Calling matchTree " + node1.val + " " + node2.val);
        if (node1.val != node2.val) {
            System.out.println("no match");
            return false; // node values are different - no match
        }
        // continue matching the left and right subtrees of both node1 and node2
        boolean h = matchTree(node1.left, node2.left) && matchTree(node1.right, node2.right);
        System.out.println(h);
        return h;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        node1.left = new TreeNode(3);
        node1.right = new TreeNode(2);
        node1.left.left = new TreeNode(3);
        node1.left.right = new TreeNode(4);

        TreeNode node2 = new TreeNode(3);
        node2.right = new TreeNode(4);

        System.out.println(isSubtree(node1, node2)); // expected output: true

        node2 = new TreeNode(5);
        System.out.println(isSubtree(node1, node2));
    }
}
