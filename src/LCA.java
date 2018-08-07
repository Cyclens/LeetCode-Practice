import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;



public class LCA {
  /**
   * Iterate through each line of input.
   */
  
  TreeNode root;
  
  TreeNode findLCA(int a, int b) {
    return findLCA(root, a, b);
  }
  
  TreeNode findLCA(TreeNode TreeNode, int a, int b) {
    if (TreeNode == null)
      return null;
    
    if (TreeNode.val == a || TreeNode.val == b)
    		return TreeNode;
    
    TreeNode l_lca = findLCA(TreeNode.left, a, b);
    TreeNode r_lca = findLCA(TreeNode.right, a, b);
    
    if (l_lca != null && r_lca != null)
      return TreeNode;
    
    return (l_lca != null) ? l_lca : r_lca;
  }
  
  public static void main(String[] args) throws IOException {
    LCA tree = new LCA();
    tree.root = new TreeNode(30);
    tree.root.left = new TreeNode(8);
    tree.root.right = new TreeNode(52);
    tree.root.left.left = new TreeNode(3);
    tree.root.left.right = new TreeNode(20);
    tree.root.left.right.left = new TreeNode(10);
    tree.root.left.right.right = new TreeNode(29);
    /*InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String[] ary = line.split(" ");
      int a = Integer.parseInt(ary[0]);
      int b = Integer.parseInt(ary[1]);
      System.out.println(tree.findLCA(a, b).data);
    }*/
    int a = 8;
    int b = 52;
    System.out.println(tree.findLCA(a, b).val);
  }
}
