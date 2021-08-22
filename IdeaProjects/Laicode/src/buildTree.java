import java.util.*;

//           6
//     3          5
// 7      8    1      2


//preOrder  {6,3,7,8,5,1,2}
//postOrder {7,8,3,1,2,5,6}

//inOrder   {7,3,8,6,1,5,2}

public class buildTree {
    public TreeNode buildTree(int[] preOrder, int[] inOrder){
        Map<Integer, Integer> idxMap = buildMap(inOrder);
        TreeNode root = helper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, idxMap);
        return root;
    }

    private Map<Integer, Integer> buildMap(int[] inOrder){
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++){
            idxMap.put(inOrder[i], i);
        }
        return idxMap;
    }

    private TreeNode helper(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft,
                            int inRight, Map<Integer,Integer> idxMap){
        if (preLeft > preRight){
            return null;
        }

        TreeNode root = null;

        if (preOrder[preLeft] != '#'){
            root = new TreeNode(preOrder[preLeft]);
        }

        if (root != null) {
            int leftSize = idxMap.get(root.key) - inLeft;

            root.left = helper(preOrder, preLeft + 1, preLeft + leftSize, inOrder,
                    inLeft, inLeft + leftSize - 1, idxMap);
            root.right = helper(preOrder, preLeft + leftSize + 1, preRight, inOrder,
                    inLeft + leftSize + 1, inRight, idxMap);
        }
        return root;
    }

    public List<Integer> postOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.key);
    }

    public List<Integer> inOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        helperIn(root, res);
        return res;
    }

    private void helperIn(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        helperIn(root.left, res);
        res.add(root.key);
        helperIn(root.right, res);
    }

    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        helperPre(root, res);
        return res;
    }

    private void helperPre(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        res.add(root.key);
        helperPre(root.left, res);
        helperPre(root.right, res);
    }
}





