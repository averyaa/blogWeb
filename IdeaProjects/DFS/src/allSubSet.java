import java.util.List;
import java.util.ArrayList;

public class allSubSet {
    public List<String> subSets(String set){
        List<String> result = new ArrayList<String>();
        if (set == null){
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        System.out.println(sb);
        if (index == set.length){
            result.add(sb.toString());
            System.out.println(result);
            return;
        }
        helper(set, sb, index + 1, result);
        helper(set, sb.append(set[index]), index + 1, result);
        sb.deleteCharAt(sb.length() - 1);
    }
}
