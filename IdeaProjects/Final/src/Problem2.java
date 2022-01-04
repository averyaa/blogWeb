import java.util.ArrayDeque;
import java.util.Queue;

public class Problem2 {
    public boolean isCousin(TreeNode root, TreeNode a, TreeNode b){
        if (root == null){
            return false;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int found = 0;
            for (int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                // node a and b are under same parent
                if (curr.left != null && curr.right != null &&
                        (curr.left == a || curr.left == b) && (curr.right == b || curr.right == a)){
                    return false;
                }

                // node a and b are in the same level
                if (curr.left != null){
                    if (curr.left == a || curr.left == b){
                        found ++;
                        q.offer(curr.left);
                    }
                }
                if (curr.right != null){
                    if (curr.right == a || curr.right == b){
                        found ++;
                        q.offer(curr.right);
                    }
                }
                if (found == 2){
                    return true;
                }
            }

        }
        return false;

    }
}
