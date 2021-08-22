import java.util.ArrayList;
import java.util.List;

public class printParentheses {
    public void printParentheses(int n){
        //assume n > 0
        List<String> result = new ArrayList<>();
        char[] cur = new char[n*2];
        dfs(n, n, 0, cur, result);
        // print
        for (int i = 0; i < result.size() - 1; i++){
            printEach(result.get(i));
            System.out.println("\n");
        }
        printEach(result.get(result.size() - 1));
    }

    private void dfs(int left, int right, int index, char[] cur, List<String> result){

        if (index == cur.length){
            result.add(new String(cur));
            return;
        }

        if (left > 0){
            cur[index] = '{';
                dfs(left - 1, right, index + 1, cur, result);
            }

            if (right > left){
                cur[index] = '}';
            dfs(left, right - 1, index + 1, cur, result);
        }
    }
    private void printEach(String input){
        int level = 0;
        for (int i = 0; i < input.length(); i++){
            //if (input.charAt(i) == ‘{‘ && level == 0){
            //	System.out.println(“if { \n”);
            //	level++;
            //}
            if (input.charAt(i) == '{'){
                // if level == 0, spaces == empty string
                String spaces = "";
                for (int j = 0; j < level; j++){
                    spaces += "  ";
                }

                System.out.println(spaces + "if {\n");
                level++;
                }
            else if (input.charAt(i) == '}'){
                String spaces = "";
                for (int j = 0; j < level; j++){
                    spaces += "  ";
                }
                System.out.println(spaces + "}");
                level--;
            }
        }
    }
}
