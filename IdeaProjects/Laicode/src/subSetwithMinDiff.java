public class subSetwithMinDiff {
    //Given a set of n integers,
    //divide the set in two subsets of n/2 size each
    //such that the difference of the sum of two subsets
    //is as minimum as possible.

    public int minDifference(int[] array) {


        return recursion(array, 0, 0, 0, 0);
    }

    private int recursion(int[] array, int index, int sum1, int sum2, int size){
        if (index == array.length){
            if (size == array.length  / 2){
                return Math.abs(sum1 - sum2);
            } else {
                return Integer.MAX_VALUE;
            }

        }

        return Math.min(recursion(array, index + 1, sum1 + array[index], sum2, size + 1),
                recursion(array, index + 1, sum1, sum2 + array[index], size));
    }
}
