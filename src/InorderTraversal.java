import java.util.*;

public class InorderTraversal {

	public static List<Integer> inorder (TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		while (curr != null || !stack.empty()) {
			while (curr != null) {
				stack.add(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			list.add(curr.val);
			curr = curr.right;
		}
		return list;
	}
	
	public static void main (String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		List<Integer> res = inorder(root);
		System.out.println(res.toString());
	}
}
