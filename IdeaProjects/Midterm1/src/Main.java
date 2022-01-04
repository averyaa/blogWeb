import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args){

        /**
        Nqueens solution = new Nqueens();
        List<List<Integer>> result1 = solution.nQueens(4);

        for (int i = 0; i < result1.size(); i++){
            System.out.println(result1.get(i));
        }
        */

        /**
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(-1);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node5.left = node7;
        node5.right = node8;
        node6.left = node9;
        node6.right = node10;

        //                8
        //            /      \
        //          7          3
        //        /  \       /   \
        //       5    6    9      -1
        //                / \     / \6
        //               2   3   1   4

        treeNodeSum maxSumSolution = new treeNodeSum();
        int result2 = maxSumSolution.maxPathSum(root);
        System.out.println(result2);
         */

        curPalindrome cut = new curPalindrome();
        int result3 = cut.minCut("ababbbabbababa");
        System.out.println(result3);
    }
}
