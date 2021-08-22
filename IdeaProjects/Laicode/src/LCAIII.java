public class LCAIII {
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        TreeNode result = helper(root, one, two);
        if (result.key == one.key){
            if (helper(one, two, two) == null){
                return null;
            }
        } else if (result.key == two.key){
            if (helper(two, one, one) == null){
                return null;
            }
        }
        return result;
    }

    private TreeNode helper(TreeNode root, TreeNode one, TreeNode two){
        // if find the node or reach to the end of tree
        if(root == null || root.key == one.key || root.key == two.key){
            return root;
        }

        TreeNode left = helper(root.left, one, two);
        TreeNode right = helper(root.right, one, two);

        if (left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }
}

//           6
//     3          5
// 7      8    1       2
