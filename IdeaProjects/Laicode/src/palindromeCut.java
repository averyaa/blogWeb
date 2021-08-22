import java.util.Arrays;

public class palindromeCut {
    public int minCuts(String input){
        // assume input is not null
        if (input.length() == 0) return 0;

        int[] minCuts = new int[input.length() + 1];
        Arrays.fill(minCuts, input.length());
        minCuts[0] = 0;
        minCuts[1] = 0;

        // test
        //System.out.println(isPalindrome("aba"));
        //System.out.println(isPalindrome("a"));
        //System.out.println(isPalindrome("abb"));

        for (int i = 2; i < minCuts.length; i++){
            for (int j = i - 1; j >= 0; j--){
                if (isPalindrome(input.substring(j, i))){
                    if (j == 0) {
                        minCuts[i] = 0;
                    } else {
                        minCuts[i] = Math.min(minCuts[i], minCuts[j] + 1);
                    }
                }
            }

        }

        return minCuts[minCuts.length - 1];

    }

    private boolean isPalindrome(String input){
        int left = 0;
        int right = input.length() - 1;
        while (left < right){
            if (input.charAt(left) != input.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


