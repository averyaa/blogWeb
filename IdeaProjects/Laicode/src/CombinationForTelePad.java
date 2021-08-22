import java.util.*;

public class CombinationForTelePad {
    public String[] combinations(int number) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        // Get each digit of the number
        Deque<Integer> stack = new LinkedList<>();

        while(number > 0){
            stack.push(number % 10);
            number = number / 10;
        }

        StringBuilder cur = new StringBuilder();
        List<String> input = new ArrayList<>();
        List<String> result = new ArrayList<>();

        while(!stack.isEmpty()){
            String curStr = map.get(stack.pop());
            if ( curStr != ""){
                input.add(curStr);
            }

        }

        combination(cur, 0, input, result);
        String[] resultArray = new String[result.size()];
        for (int i = 0; i < result.size(); i++){
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    private void combination(StringBuilder cur, int index, List<String> input, List<String> result){
        if (index == input.size()){
            result.add(cur.toString());
            return;
        }

        String curStr = input.get(index);
        for (int i = 0; i < curStr.length(); i++){
            cur.append(curStr.charAt(i));
            combination(cur, index + 1, input, result);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
