import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allSubSettwo {

    public List<String> subSets(String set) {
        // Write your solution here.

        List<String> result = new ArrayList<String>();

        if (set == null){
            return result;
        }

        char[] array = set.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();

        helper(array, 0, sb, result);
        return result;
    }


    private void helper(char[] array, int index, StringBuilder sb, List<String> result){
        if (index == array.length){
            result.add(sb.toString());
            return;
        }

        sb.append(array[index]);

        helper(array, index + 1, sb, result);

        sb.deleteCharAt(sb.length() - 1);

        while(index < array.length - 1 && array[index] == array[index + 1]){
            index++;
        }

        helper(array, index + 1, sb, result);

    }
}
