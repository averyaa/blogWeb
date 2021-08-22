import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class allValidParenthesesIII {
    private static final char[] PS = new char[]{'{', '}', '<', '>', '(', ')'};
    public List<String> validParenthesesIII(int l, int m, int n) {
        // assume l, m, n >= 0
        // l + m + n > 0

        Deque<Integer> stack = new LinkedList<Integer>();
        int[] remain = new int[]{l, l, m, m, n, n};
        StringBuilder cur = new StringBuilder();
        int maxLen = (l + m + n) * 2;
        List<String> result = new ArrayList<>();

        helper(cur, stack, maxLen, remain, result);

        return result;
    }

    private void helper(StringBuilder cur, Deque<Integer> stack, int maxLen,
                        int[] remain, List<String> result){
        if (cur.length() == maxLen){
            result.add(cur.toString());
            return;
        }

        for (int i = 0; i < remain.length; i++){
            // left
            if (i % 2 == 0){
                if (remain[i] > 0 && (stack.isEmpty() || i > stack.peek())){
                    cur.append(PS[i]);
                    stack.push(i);
                    remain[i]--;
                    helper(cur, stack, maxLen, remain, result);
                    cur.deleteCharAt(cur.length() - 1);
                    stack.pop();
                    remain[i]++;
                }
            }
            //  right
            else {
                if(!stack.isEmpty() && stack.peek() == i - 1){
                    cur.append(PS[i]);
                    stack.pop();
                    remain[i]--;
                    helper(cur, stack, maxLen, remain, result);
                    cur.deleteCharAt(cur.length() - 1);
                    stack.push(i - 1);
                    remain[i]++;
                }
            }
        }
    }
}
