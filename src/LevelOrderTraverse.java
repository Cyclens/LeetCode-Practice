import java.util.*;

class Node
{
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class BinaryTree
{
    // Root of the Binary Tree
    Node root;
 
    public BinaryTree()
    {
        root = null;
    }
}

public class LevelOrderTraverse {
	public static void printbyLevel(Node root) {
		Queue<Node> Q = new LinkedList<Node>();
		Q.add(root);
		while (!Q.isEmpty()) {
			Node curr = Q.poll();
			System.out.println(curr.data);
			
			if (curr.left != null) {
				Q.add(curr.left);
			}
			if (curr.right != null) {
				Q.add(curr.right);
			}
		}
	}
	
	public static void printbyLevelDFS(Node root) {
		int h = height(root);
		for (int i = 1; i <= h; i++) {
			printthisLevel(root, i);
		}
	}
	
	private static void printthisLevel(Node root, int level) {
		// TODO Auto-generated method stub
		if (root == null) return;
		if (level == 1) System.out.println(root.data);
		else if (level > 1){
			printthisLevel(root.left, level - 1);
			printthisLevel(root.right, level - 1);
		}
	}

	public static int height (Node root) {
		if (root == null) return 0;
		else {
			int height;
			int lheight = height(root.left);
			int rheight = height(root.right);
			
			height = Math.max(lheight, rheight) + 1;
			return height;
		}
	}
	
    public static void main(String args[])
    {
       BinaryTree tree = new BinaryTree();
       tree.root= new Node(1);
       tree.root.left= new Node(2);
       tree.root.right= new Node(3);
       tree.root.left.left= new Node(4);
       tree.root.left.right= new Node(5);
       System.out.println("Level order traversal of binary tree is ");
       LevelOrderTraverse.printbyLevel(tree.root);
       System.out.println("Level order traversal by DFS of binary tree is ");
       LevelOrderTraverse.printbyLevelDFS(tree.root);
    }
}