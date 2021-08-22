import java.util.*;

public class postOrder {
    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> preOrder = new LinkedList<TreeNode>();
        preOrder.offerFirst(root);
        while(!preOrder.isEmpty()){
            TreeNode current = preOrder.pollFirst();
            result.add(current.key);
            if (current.left != null){
                preOrder.offerFirst(current.left);
            }
            if (current.right != null){
                preOrder.offerFirst(current.right);
            }
        }

        for (Integer elem : result){
            System.out.println(elem);
        }


        Collections.reverse(result);
        return result;
    }
}
