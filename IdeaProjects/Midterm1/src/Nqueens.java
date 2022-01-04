// input: int N  output: List<List<Integer>>
//                       rows      columns
// assume N > 0
// R:
// 1. use DFS
// 2. N levels
//    0, 1, 2, .... n-1
//    put queens on the attempted column, check if valid, if valid, move to next step,
//    otherwise move it to another attempted column
//    valid: column && diagonal

import java.util.List;
import java.util.ArrayList;

public class Nqueens{
    public List<List<Integer>> nQueens(int n){
        // result is used to store all the solutions
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // cur is used to store one possible solution
        List<Integer> cur = new ArrayList<Integer>();

        helper(n, 0, cur, result);
        return result;
    }

    private void helper(int n, int index, List<Integer> cur, List<List<Integer>> result){
        if (cur.size() == n){
            result.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = 0; i < n; i++){
            if (isValid(cur, i)){
                cur.add(i);
                helper(n, index + 1, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> cur, int column){
        int row = cur.size();

        for (int j = 0; j < row; j++){
            if (column == cur.get(j) || Math.abs(column - cur.get(j)) == (row - j)){
                return false;
            }
        }
        return true;
    }

}
