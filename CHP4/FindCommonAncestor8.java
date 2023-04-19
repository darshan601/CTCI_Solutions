package CHP4;

public class FindCommonAncestor8 {
    static boolean findCommon(TreeNode root, int val1, int val2) {
        if (root == null)
            return false;

        if ((root.val == val1) || (root.val == val2))
            return true;

        boolean left = findCommon(root.left, val1, val2);

        boolean right = findCommon(root.right, val1, val2);

        if ((left) && (right))
            System.out.println("Root common ancestor " + root.val);

        if ((left) || (right))
            return true;

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(10);
        root.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(5);
        findCommon(root, 5, 4);
    }
}
