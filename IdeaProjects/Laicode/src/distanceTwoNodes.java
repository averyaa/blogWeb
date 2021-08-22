public class distanceTwoNodes {
    public int getDistance(TreeNode root, TreeNode one, TreeNode two){
        // what do you want to get from left and right child
        //   found the node or not, if found, = 1
        //   if not return 0
        // what do you want to do in current level
        //   get left and right
        // what do you want to report to the parent
        //   if left == 0 return right || if right == 0 return left
        //   if (left != 0 && right != 0) return left + right


        // assume root, one, two are not null
        // assume one, two are all in the tree

        return helper(root, one, two);
    }

    private int helper(TreeNode root, TreeNode one, TreeNode two){
        if (root == null){
            return 0;
        }

        int left = 0;
        int right = 0;

        left = helper(root.left, one, two);
        right = helper(root.right, one, two);

        if (left != 0 && right != 0){
            return left + right;
        }

        if (root.key == one.key || root.key == two.key){
            return 1;
        }

        return left == 0 ? right : left;
    }
}
