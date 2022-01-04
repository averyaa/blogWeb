import java.util.List;

public class main {
    public static void main(String[] args) {
        //compressString compress = new compressString();
        //String result = compress.compress("abbbbccdddddde");
        //System.out.println(result);

        /** pieces pieces = new pieces();
         int[] arr = new int[]{15,88};
         int[][] piece = new int[][]{{15}, {88}};
         boolean canFormArray = pieces.canFormArray(arr, piece);
         System.out.println(canFormArray); **/


        reverseAlphabet reverseAlphabet = new reverseAlphabet();
        String input = "-a++b--c^";

        String result = reverseAlphabet.reverseAlphabetCharsOnly(input);
        System.out.println(result);
    }
}
