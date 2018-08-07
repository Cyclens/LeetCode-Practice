import java.util.*;

public class ValidBST {
	public static boolean isValidBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
			root = stack.pop();
			if (pre != null && root.val <= pre.val) return false;
			pre = root;
			root = root.right;
		}
		return true;
	}
	
	public static void main (String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		boolean isBST = isValidBST(root);
		System.out.println(isBST);
	}
	
}
