class TreeNode {
	int val;
	TreeNode left, right;
	
	public TreeNode(int value) {
		val = value;
		left = right = null;
	}
}

public class LargestPerfectSubtree {

    public static void main(String[] args){
        
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(6);
        node.right.left = new TreeNode(5);
        node.right.left.left = new TreeNode(7);
        node.right.left.right = new TreeNode(8);
        node.right.right.left = new TreeNode(9);
        node.right.right.right = new TreeNode(10);
        node.right.right.right.left = new TreeNode(11);

        LargestPerfectSubtree res = new LargestPerfectSubtree();
        int[] a = res.largestCompleteTree(node);
        System.out.println(a.length);
        
    }

    public int[] largestCompleteTree(TreeNode root){
        int[] max = new int[1];
        helper(root, max);
        return max;
    }

    private Info helper(TreeNode root, int[] max){
        //Base case:
        if(root == null){
            return new Info(0, true);
        }

        if(root.left == null && root.right == null){
            max[0] = Math.max(max[0], 1);
            return new Info(1, true);
        }

        //Recursion
        Info leftInfo = helper(root.left, max);
        Info rightInfo = helper(root.right, max);  

        //Process based on left subtree and right subtree.
        //Neither is complete.
        if(!leftInfo.isComplete && !rightInfo.isComplete){
            //Do not need to update the max value.
            return new Info(-1, false);
        }
        //One of the subtree is complete, the current tree is not complete
        else if(!leftInfo.isComplete || !rightInfo.isComplete){
            if(leftInfo.isComplete){
                max[0] = Math.max(max[0], leftInfo.size);
                return new Info(-1, false);//the value has been recorded
            }else{
                max[0] = Math.max(max[0], rightInfo.size);
                return new Info(-1, false);
            }
        }
        //Both subtrees are complete,           
        else{
            int size = 0;
            if(((rightInfo.size & (rightInfo.size + 1)) == 0 &&
                leftInfo.size >= rightInfo.size &&
                leftInfo.size <= rightInfo.size*2 + 1)||
                ((leftInfo.size & (leftInfo.size + 1)) == 0 &&
                        rightInfo.size >= (leftInfo.size - 1)/2 &&
                        rightInfo.size <= leftInfo.size))
                {
                    size = leftInfo.size + rightInfo.size + 1;
                    max[0] = Math.max(max[0], size);
                    return new Info(size, true);
                }
             else{ //find the subtree with the greater size
                size = leftInfo.size > rightInfo.size ? leftInfo.size : rightInfo.size;
                max[0] = Math.max(max[0], size);
                return new Info(0, false);
            } 
        }   
    }
    class Info {
        boolean isComplete;
        int size;

        public Info(int size, boolean isComplete){
            this.isComplete = isComplete;
            this.size = size;
        }
    }
}