public class arrayToTree {
    public TreeNode arrayToTree (Integer[] array, int index){
        TreeNode root = null;
        if (index < array.length){
            Integer value = array[index];
            if (value == null){
                return null;
            }
            root = new TreeNode(value);
            root.left = arrayToTree(array, 2*index+1);
            root.right = arrayToTree(array, 2*index+2);
            return root;
        }
        return root;
    }
}
