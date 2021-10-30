package leetcode;

public class MaxDepthOfBinaryTree {


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
    public int maxDepth(TreeNode root) {

        if (root == null){
            return 0;
        }

        TreeNode temp = root;
        int leftDepth = maxDepth(temp.left);
        int rightDepth = maxDepth(temp.right);

        int maxDepth = leftDepth > rightDepth ? leftDepth : rightDepth;
        return maxDepth +1;
    }
}
