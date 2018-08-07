
public class LongestUnivaluePath {
	int len;
	public int longestUnivaluePath(TreeNode root) {
		if(root == null) return 0;
		len = 0;
		getLen(root, root.val);
		return len;
	}
	private int getLen(TreeNode node, int val) {
		// TODO Auto-generated method stub
		if (node == null) return -1;
		int left = getLen(node.left, val);
		int right = getLen(node.right, val);
		len = Math.max(len, left + right);
		if (node.val == val) return Math.max(left, right) + 1;
		return 0;
	}
}
