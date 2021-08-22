import java.util.ArrayList;
import java.util.List;
// 012
// ABC

// A
// AB     AxB

public class allSchedule {
    public List<String> allSchedule(String input){
        // assume input is not null and length is larger than 1
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        // index represent the interval
        sb.append(input.charAt(0));
        dfs(input, 1, sb, result);
        return result;
    }

    private void dfs(String input, int index, StringBuilder sb, List<String> result){
        // base case
        if (index == input.length()){
            result.add(sb.toString());
            return;
        }

        // recursion rule
        sb.append(input.charAt(index)); //AB
        dfs(input, index + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        sb.append('x');
        sb.append(input.charAt(index)); //AxB
        dfs(input, index + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
    }


}
