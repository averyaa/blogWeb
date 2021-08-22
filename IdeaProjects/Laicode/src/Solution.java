import java.util.ArrayList;
import java.util.List;



public class Solution {
    public List<String> permutations(String input) {
        List<String> result = new ArrayList<String>();
        char[] inputArray = input.toCharArray();
        char[] cur = inputArray;

        helper(inputArray, 0, cur, result);

        return result;
    }


    private void helper(char[] inputArray, int index, char[] cur, List<String> result){

        if (index == inputArray.length - 1){
            result.add(new String(cur));
            return;
        }

        cur = inputArray;

        for (int i = 0; i < cur.length; i++){
            cur = swap(cur, index, i);
            helper(inputArray, index + 1, cur, result);
            cur = swap(cur, index, i);
        }
    }

    private char[] swap(char[] array, int index, int i){
        char temp = array[index];
        array[index] = array[i];
        array[i] = temp;
        return array;
    }
}
