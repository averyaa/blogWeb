import org.w3c.dom.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class cousinsInBinaryTree {
    int recordedDepth = -1;
    boolean isCousin = false;

    public boolean isCousin(TreeNode root, TreeNode one, TreeNode two){
        helper(root, one, two, 0);
        return this.isCousin;
    }

    private boolean helper(TreeNode root, TreeNode one, TreeNode two, int depth){
        if (root == null){
            return false;
        }

        // if the cur depth is larger than the depth that found for the first node,
        // no need to go forward
        if (this.recordedDepth != -1 && depth > this.recordedDepth){
            return false;
        }

        if (root.key == one.key || root.key == two.key){
            if (this.recordedDepth == -1){
                this.recordedDepth = depth;
            }
            return this.recordedDepth == depth;

        }

        boolean left = helper(root.left, one, two, depth + 1);
        boolean right = helper(root.right, one, two, depth + 1);

        // if left and right are both true
        // but if recordedDepth == depth + 1,
        // means that the cur level is the immediate parent level of two nodes. false
        if (left && right && this.recordedDepth != depth + 1){
            this.isCousin = true;
        }

        return left || right;
    }
}


//           6
//     3          5
// 7      8    1       2

