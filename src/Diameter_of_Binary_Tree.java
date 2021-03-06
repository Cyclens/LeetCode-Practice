
public class Diameter_of_Binary_Tree {

	int max = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return max;
	}
	private int maxDepth(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		max = Math.max(max, left + right);
		return Math.max(left, right) + 1;
	}
}
