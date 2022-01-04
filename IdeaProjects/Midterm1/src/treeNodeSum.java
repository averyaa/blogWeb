class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}

public class treeNodeSum {
    public int maxPathSum(TreeNode root){
        int[] result = new int[1];
        maxPathSumHelper(root, result);
        return result[0];
    }


    private int maxPathSumHelper(TreeNode root, int[] result){
        // base case, return a null
        if(root == null){
            return 0;
        }

        // find the max sum from root.left to a leaf, same for root.right
        int left = maxPathSumHelper(root.left, result);
        int right = maxPathSumHelper(root.right, result);

        // update current maxPathSum from one leaf to another leaf using the root as connection point
        if (root.left != null && root.right != null){
            result[0] = Math.max(result[0], root.val + left + right);
            // return the max sum from root to one leaf
            return root.val + Math.max(left, right);
        }

        return root.left == null?(right + root.val):(left + root.val);
    }

}
