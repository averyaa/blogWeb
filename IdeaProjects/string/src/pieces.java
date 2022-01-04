import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class pieces {
        public boolean canFormArray(int[] arr, int[][] pieces) {

            List<List<Integer>> resultLst = new ArrayList<List<Integer>>();

            helper(pieces, 0, resultLst);

            for (int i = 0; i < resultLst.size(); i++){
                List<Integer> cur = resultLst.get(i);
                for (int j = 0; j < cur.size(); j++){
                    if (cur.get(j) != arr[j]){
                        return false;
                    }
                }
                return true;
            }

            return false;

        }

        private void helper(int[][] pieces, int index, List<List<Integer>> resultLst){
            if (index == pieces.length){
                List<Integer> curArrayLst = new ArrayList<Integer>();
                for (int[] piece : pieces){
                    for (int elem : piece){
                        curArrayLst.add(elem);
                    }
                }

                resultLst.add(curArrayLst);
            }

            Set<int[]> used = new HashSet<int[]>();
            for (int i = index; i < pieces.length; i++){
                if (used.add(pieces[i])){
                    swap(pieces, i, index);
                    helper(pieces, index + 1, resultLst);
                    swap(pieces, i, index);
                }
            }

        }

        private void swap(int[][] pieces, int left, int right){
            int[] temp = pieces[left];
            pieces[left] = pieces[right];
            pieces[right] = temp;
        }

}
