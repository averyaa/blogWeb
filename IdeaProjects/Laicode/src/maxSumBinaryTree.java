public class maxSumBinaryTree {
    public int maxPathSum(TreeNode root) {
        // Write your solution here

        int[] maxSum = new int[]{Integer.MIN_VALUE};
//        if (root == null) {
//            return maxSum[0];
//        }

        helper(root, maxSum);

        return maxSum[0];
    }

    private int helper(TreeNode root, int[] maxSum){
        if (root == null){
            return 0;
        }

        // return the value of leaf node
        if (root.left == null && root.right == null){
            return root.key;
        }

        int left = helper(root.left, maxSum);
        int right = helper(root.right, maxSum);

        if (root.left != null && root.right != null){
            maxSum[0] = Math.max(maxSum[0], left + root.key + right);
            return Math.max(left, right) + root.key;
        }

        return root.left == null ? right + root.key: left + root.key;

    }
}
