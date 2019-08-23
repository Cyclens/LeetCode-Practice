package Google;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree_Traversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null)
			return list;
		
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> tempLevel = new ArrayList<Integer>();
			int numNodes = queue.size();
			for (int i = 0; i < numNodes; i++) {
				if (queue.peek().left != null)
					queue.add(queue.peek().left);
				if (queue.peek().right != null)
					queue.add(queue.peek().right);
				tempLevel.add(queue.poll().val);
			}
			list.add(tempLevel);
		}
		return list;
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		/*
		 * 1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   		 * 2. Visit the root.
   		 * 3. Traverse the right subtree, i.e., call Inorder(right-subtree)
		 */
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

	public List<Integer> preorderTraversal(TreeNode node) {
		/*
		 * 1. Visit the root.
		   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
		   3. Traverse the right subtree, i.e., call Preorder(right-subtree) 
		   */
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> rights = new Stack<TreeNode>();
		while (node != null) {
			list.add(node.val);
			if (node.right != null) {
				rights.push(node.right);
			}
			node = node.left;
			if (node == null && !rights.isEmpty()) {
				node = rights.pop();
			}
		}
		return list;
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		/*
		 *  1. Traverse the left subtree, i.e., call Postorder(left-subtree)
   			2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   			3. Visit the root.
		 */
		LinkedList<Integer> result = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				result.addFirst(p.val); // Reverse the process of preorder
				p = p.right; // Reverse the process of preorder
			} else {
				TreeNode node = stack.pop();
				p = node.left; // Reverse the process of preorder
			}
		}
		return result;
	}

	static Stack<TreeNode> s1, s2;

	public static void postOrderIterative(TreeNode root) {
		// Create two stacks
		s1 = new Stack<>();
		s2 = new Stack<>();

		if (root == null)
			return;

		// push root to first stack
		s1.push(root);

		// Run while first stack is not empty
		while (!s1.isEmpty()) {
			// Pop an item from s1 and push it to s2
			TreeNode temp = s1.pop();
			s2.push(temp);

			// Push left and right children of
			// removed item to s1
			if (temp.left != null)
				s1.push(temp.left);
			if (temp.right != null)
				s1.push(temp.right);
		}

		// Print all elements of second stack
		while (!s2.isEmpty()) {
			TreeNode temp = s2.pop();
			System.out.print(temp.val + " ");
		}
	}
	public static void main(String[] args) 
    {
        // Let us construct the tree 
        // shown in above figure
         
        TreeNode root = null;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
 
        //postOrderIterative(root);
        System.out.println(new Binary_Tree_Traversal().levelOrder(root) + ", level order");
        System.out.println(new Binary_Tree_Traversal().inorderTraversal(root) + ", in-order");
        System.out.println(new Binary_Tree_Traversal().postorderTraversal(root) + ", post order");
        System.out.println(new Binary_Tree_Traversal().preorderTraversal(root) + ", pre order");
    }
}
