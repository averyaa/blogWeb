import java.util.*;

public class allSubSets {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> result = new ArrayList<>();
        if (set == null){
            return result;
        }

        char[] input = set.toCharArray();
        Arrays.sort(input);
        StringBuilder sb = new StringBuilder();



        helper(input, 0, sb, result);
        return result;
    }

    private void helper(char[] input, int index, StringBuilder sb, List<String> result){
        if (index == input.length){
            result.add(sb.toString());
            return;
        }

        sb.append(input[index]);
        helper(input, index + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        while(index < input.length - 1 && input[index + 1] == (input[index])){
            index++;
        }

        helper(input, index + 1, sb, result);
    }
}
