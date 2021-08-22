public class isSymmetric {
    public boolean isSymmetric(TreeNode root){
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        } else if (left == null || right == null){
            return false;
        } else if (left.key != right.key ){
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
