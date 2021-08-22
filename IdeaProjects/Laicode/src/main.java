import java.util.*;
import java.util.ArrayList;


public class main {
    public static void main(String[] args){

        /**Solution solution = new Solution();
        int[] input = new int[]{15, 5, 1};
        List<String> result = solution.permutations("abc");

        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }


        compressString compress = new compressString();
        String input = "abbbccdddddddde";
        System.out.println(compress.compress(input));
        **/

        /**TreeNode root = buildTree(new int[]{3, 4, 5, 5, 6, 6, 4}, 0, 6);

        //postOrder postOrder = new postOrder();
        //List<Integer> result1 = postOrder.postOrder(root);
        //System.out.println(result1);

        isSymmetric solution1 = new isSymmetric();
        boolean result2 = solution1.isSymmetric(root);
        System.out.println(result2);**/

        /**int[] A = new int[]{1,3,5};
        int[] B = new int[]{4,8};

        kthSmallSum solution2 = new kthSmallSum();
        int result3 = solution2.solution(3, A, B);
        System.out.println(result3);**/

        /**int[][] sortedMatrix = new int[][]{{1,  2,  3,  4},
                                           {11, 12, 13, 14},
                                           {15, 16, 17, 18},
                                           {19, 20, 21, 22}};

        kSmallestSortedMatrix solution3 = new kSmallestSortedMatrix();
        int result4 = solution3.kthSmallest(sortedMatrix, 4);
        System.out.println(result4);**/

        /**int[] unsortedArray = new int[]{1,2,3,4};
        kSmallUnsortedArray solution4 = new kSmallUnsortedArray();
        int[] result5 = solution4.kSmallest(unsortedArray, 2);
        for (int value : result5) {
            System.out.println(value);
        }**/

        /**topKFreqWords solution5 = new topKFreqWords();
        String[] combo = new String[]{"apple", "banana", "apple", "pear", "orange",
                                      "pear", "apple", "apple", "lime", "orange"};
        String[] result6 = solution5.topKFrequent(combo, 3);
        for (String value : result6) {
            System.out.println(value);
        }**/

        /**
        String input = "njdsdrhooknfffgelevmahooknfffgthooknfffghooknfffghooknfffgehooknfffgljlgmqqhooknfffgvbvlh";
        String source = "hooknfffg";
        String target = "uddw";
        stringReplace solution6 = new stringReplace();
        String result7 = solution6.replace(input, source, target);
        System.out.println(result7);**/

        /**removeSpace solution7 = new removeSpace();
        String input = "      ";
        String result8 = solution7.removeSpaces(input);
        System.out.println(result8);**/

        /**printParentheses solution8 = new printParentheses();
        solution8.printParentheses(3);**/

        /**String one = "sigh";
        String two = "asith";

        editDistance solution9 = new editDistance();
        int result9 = solution9.editDistance(one, two);

        System.out.println(result);**/

        /**int[][] matrix = new int[][]{{1, 0, 0},
                                     {0, 0, 0},
                                     {0, 0, 0}};
        largestSquare solution10 = new largestSquare();
        int result10 = solution10.largest(matrix);
        System.out.println(result10);**/

        /**String input = "ababbbabbababa";
        palindromeCut solution11 = new palindromeCut();
        int result11 = solution11.minCuts(input);
        System.out.println(result11); // 3**/

//        String input = "apple";
//        String pattern = "a4e";
//        stringAbbreviation solution12 = new stringAbbreviation();
//        boolean result12 = solution12.match(input, pattern);
//        System.out.println(result12);
//
//        Integer[] input1 = new Integer[]{-15,2,11,null,null,6,14,null,null,null,null,null,8}; //39
//        Integer[] input2 = new Integer[]{-15,2,11,null,null,6,14}; // 31
//        Integer[] input3 = new Integer[]{-15,2,null,null,null}; //Integer.MIN_VAlUE
//        TreeNode root = new TreeNode(0);
//        buildTree newTree = new buildTree();
//        TreeNode newRoot = newTree.buildTree(input1, root,0);
//        assert newRoot != null;
//        System.out.println(newRoot.key);
//        System.out.println(newRoot.left.key);
//        System.out.println(newRoot.right.key);
//        System.out.println(newRoot.left.left == null);
//        System.out.println(newRoot.right.left.right.key);
//
//        maxSumBinaryTree solution13 = new maxSumBinaryTree();
//        int result13 = solution13.maxPathSum(newRoot);
//        System.out.println(result13);

//        int[][] matrix = new int[][]{{1, 0, 1, 1, 1},
//                                     {1, 1, 1, 1, 1},
//                                     {1, 1, 0, 1, 0},
//                                     {1, 1, 1, 1, 1},
//                                     {1, 1, 1, 0, 0}};
//
//        maxSquareSurroundedOne solution14 = new maxSquareSurroundedOne();
//        int result14 = solution14.largestSquareSurroundedByOne(matrix);
//        System.out.println(result14);

//        allSubSets solution15 = new allSubSets();
//        List<String> result15 = solution15.subSets("abab");
//        System.out.println(result15);
        //["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]

//        allSubSetsK solution16 = new allSubSetsK();
//        List<String> result16 = solution16.subSetsOfSizeK("tebh", 4);
//        List<String> result17 = solution16.subSetsOfSizeK("abab", 4);
//        System.out.println(result16);
        //System.out.println(result17);

//        allValidParenthesesIII solution17 = new allValidParenthesesIII();
//        List<String> result18 = solution17.validParenthesesIII(3, 1, 0);
//        System.out.println(result18);

//        subSetwithMinDiff solution18 = new subSetwithMinDiff();
//        int result19 = solution18.minDifference(new int[]{-2,-9,-3,-1,-1});
//        System.out.println(result19);

//        CombinationForTelePad solution19 = new CombinationForTelePad();
//        String[] result20 = solution19.combinations(5002);
//        for (int i = 0; i < result20.length; i++) {
//            System.out.println(result20[i]);
//        }

//        passByValue test = new passByValue();
//        test.Money();
//        LargestRec solution20 = new LargestRec();
//        int[] input = new int[]{2,1,5,6,2,3};
//        int result21 = solution20.largest(input);
//        System.out.println(result21);

//        allSchedule solution21 = new allSchedule();
//        List<String> result = solution21.allSchedule("ABCD");
//        System.out.println(result);

        int[] preOrder = {6,3,7,8,5,1,2};
        int[] postOrder = {7,8,3,1,2,5,6};
        int[] inOrder = {7,3,8,6,1,5,2};

        //           6
        //     3          5
        // 7      8    1       2

        buildTree build = new buildTree();
        TreeNode root = build.buildTree(preOrder, inOrder);

// Test the Tree, Tree is correct
//        List<Integer> postTravesal = build.postOrder(root);
//        List<Integer> inTravesal = build.inOrder(root);
//        List<Integer> preTravesal = build.preOrderTraversal(root);
//
//        System.out.println("postOrder");
//        for (Integer cur : postTravesal){
//            System.out.println(cur);
//        }
//        System.out.println("inOrder");
//        for (Integer cur : inTravesal){
//            System.out.println(cur);
//        }
//        System.out.println("preOrder");
//        for (Integer cur : preTravesal){
//            System.out.println(cur);
//        }

//        cousinsInBinaryTree solution22 = new cousinsInBinaryTree();
//        boolean result22 = solution22.isCousin(root, root.left, root.right); // false
//        TreeNode one = root.left.left;
//        TreeNode two = root.right.left;
//        System.out.println(one.key);
//        System.out.println(two.key);
        //boolean result23 = solution22.isCousin(root, one, two); // true
//        System.out.println(result22);
        //System.out.println(result23);

//        distanceTwoNodes solution23 = new distanceTwoNodes();
//        TreeNode one = new TreeNode(7);
//        TreeNode two = new TreeNode(8);
//        int result = solution23.getDistance(root, one, two);
//        System.out.println(result);

//        LCAIII solution24 = new LCAIII();
//        TreeNode one = new TreeNode(3);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(4);
//        System.out.println(root.key);
//        System.out.println(one.key);
//        System.out.println(two.key);
//        System.out.println(three.key);
//        TreeNode result1 = solution24.lowestCommonAncestor(root, one, two);
//        System.out.println(result1.key);
//
//        TreeNode result2 = solution24.lowestCommonAncestor(root, one, three);
//        System.out.println(result2);

//        LargestRec solution25 = new LargestRec();
//        int[] recs = new int[]{1,2,4,2,5};
//        int result = solution25.largest(recs);
//        System.out.println(result);

//        waterTrapI solution26 = new waterTrapI();
//        int[] trap = new int[] {4, 1, 3, 4, 7, 2, 6};
//        int result = solution26.waterTrap(trap);
//        System.out.println(result);

//        majorNumberII solution27 = new majorNumberII();
//        int[] input = new int[]{1, 2, 2, 2, 3, 5, 4, 4, 4, 4, 4, 4, 2, 2, 2};
//        List<Integer> result = solution27.majorityElement(input);
//        for (Integer ele : result){
//            System.out.println(ele);
//        }

//        sevenPuzzle solution28 = new sevenPuzzle();
//        int[] values = new int[]{4,1,2,3,5,0,6,7};
//        System.out.println(solution28.sevenPuzzle(values));



//        String[] words = new String[]{"bac","adb","abb","bdb","bba","cdd","bab","aaa","bcd","acd","cdb"};
//        List<String> wordList = Arrays.asList(words);
//
//        wordLadder solution29 = new wordLadder();
//        List<List<String>> result = solution29.findLadders("cdb", "bab", wordList);
//        for (int i = 0; i < result.size(); i++){
//            System.out.println(i + ":");
//            for (String s : result.get(i)){
//                System.out.println(s);
//            }
//        }


//        largestProdOfLen solution30 = new largestProdOfLen();
//        String[] dict = new String[]{"abcdefhi","ix","hj","x"};
//        int result = solution30.largestProduct(dict);
//        System.out.println(result);

//        int[] a = new int[]{1, 2, 3};
//        int[] b = new int[]{2, 4};
//        int[] c = new int[]{1, 2};

//        kthClosestTo000 solution31 = new kthClosestTo000();
//        List<Integer> result = solution31.kthClosestTo000(a, b, c, 10);
//        System.out.println(result);

//        char[][] gym = new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}};
//        char[][] gym2 = new char[][]{{'C','C','E','O','C'},
//                                    {'E','E','O','C','E'},
//                                    {'C','C','E','C','C'},
//                                    {'C','O','C','E','E'},
//                                    {'E','C','O','C','C'}};
//
//        placeToPutTheChair solution32 = new placeToPutTheChair();
//        List<Integer> result = solution32.putChair(gym);
//        System.out.println(result);

//        String[] words = new String[]{"wrt","wrf","er","ett","rftt"};
//        alienDictionary solution33 = new alienDictionary();
//        String result = solution33.alienOrder(words);
//        System.out.println(result);

        maxKSlidingWindows solution34 = new maxKSlidingWindows();
        int[] input = new int[]{1,2,3,2,4,2,1};
        List<Integer> result = solution34.maxWindows(input, 3);
        System.out.println(result);



    }
}










