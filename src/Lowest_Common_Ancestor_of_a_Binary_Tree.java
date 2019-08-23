
public class Lowest_Common_Ancestor_of_a_Binary_Tree {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root.val == p.val || root.val == q.val)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println("LCA(4, 5) = " + lowestCommonAncestor(root, new TreeNode(4), new TreeNode(5)).val);
		System.out.println("LCA(4, 6) = " + lowestCommonAncestor(root, new TreeNode(4), new TreeNode(6)).val);
		System.out.println("LCA(3, 4) = " + lowestCommonAncestor(root, new TreeNode(3), new TreeNode(4)).val);
		System.out.println("LCA(2, 4) = " + lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val);
	}
}
