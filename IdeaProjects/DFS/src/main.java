import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        //allSubSet test1 = new allSubSet();
        //List<String> result = test1.subSets("abc");
        //System.out.println(result);

        //parentheses test2 = new parentheses();
        //List<String> result2 = parentheses.validParentheses(3);
        //System.out.println(result2);

        allSubSettwo test3 = new allSubSettwo();
        List<String> result3 = test3.subSets("abb");
        System.out.println(result3);

    }
}
