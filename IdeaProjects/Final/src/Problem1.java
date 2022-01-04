import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    /**
     * Input: a string of universities. Each university is represented as a single capital letter.
     * Output: all possible schedules. A lowercase letter “x” means we take a break.
     * Example
     *
     * Input: String = “ABC”
     * Output:
     * ABC
     * ABxC
     * AxBC
     * AxBxC
     *
     *          A
     *      /     \
     *     AB     AxB
     *    /  \    /  \
     *  ABC
     *
     *
     */

    public List<String> schedule(String s){
        List<String> result = new ArrayList<String>();
        char[] input = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(input, sb, 0, result);
        return result;
    }

    private void helper(char[] input, StringBuilder sb, int index, List<String> result){
        if (index == input.length){
            result.add(sb.toString());
            return;
        }

        //case 1: not break
        sb.append(input[index]);
        helper(input, sb, index + 1, result);
        sb.deleteCharAt(sb.length() - 1);


        // case 2: break
        if (index > 0){
            sb.append('x');
            sb.append(input[index]);
            helper(input, sb, index + 1, result);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }


    }
}
