import java.util.List;

public class main {

    public static TreeNode arrayToTree(int[] array, int index){
        TreeNode root = null;
        if (index < array.length) {
            int value = array[index];
            root = new TreeNode(value);
            root.left = arrayToTree(array, 2 * index + 1);
            root.right = arrayToTree(array, 2 * index + 2);
            return root;
        }
        return root;
    }

    public static void main(String[] args) {
        Problem1 solution1 = new Problem1();
        List<String> result1 = solution1.schedule("ABC");
        for (int i = 0; i < result1.size(); i++) {
            System.out.println(result1.get(i));
        }


    ////////////////////////////////////////////////////////

        int[] input= new int[]{6, 3, 5, 7, 8, 1, 2};

        TreeNode root = arrayToTree(input, 0);
        Problem2 solution2 = new Problem2();
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);

        System.out.println(solution2.isCousin(root, a, b));




    ///////////////////////////////////////////////////////
        Problem3 solution3 = new Problem3();
        System.out.println(solution3.minimumBox(10));




    //////////////////////////////////////////////////////
        Problem4 solution4 = new Problem4();
        String[] strArr = new String[]{"ALICE", "CHARLES", "ERIC", "SOPHIA"};
        System.out.println(solution4.canChain(strArr));
    }


}
