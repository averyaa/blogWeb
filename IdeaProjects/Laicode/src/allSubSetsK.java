import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allSubSetsK {
    public List<String> subSetsOfSizeK(String set, int k) {

        List<String> result = new ArrayList<>();
        if (set == null || (set.length() == 0 && k > 0)){
            return result;
        }

        char[] input = set.toCharArray();
        Arrays.sort(input);
        StringBuilder sb = new StringBuilder();

        helper(input, 0, sb, result, k);
        return result;
    }

    private void helper(char[] input, int index, StringBuilder sb, List<String> result, int k){

        if (index == input.length){
            if (sb.length() == k) {
                result.add(sb.toString());
            }
            return;
        }

        sb.append(input[index]);
        helper(input, index + 1, sb, result, k);
        sb.deleteCharAt(sb.length() - 1);

        while(index < input.length - 1 && input[index] == input[index + 1]){
            index++;
        }

        helper(input, index + 1, sb, result, k);
    }
}
