public class curPalindrome {
    public int minCut(String s){
        // corner case
        if (s == null || s.length() == 1){
            return 0;
        }
        char[] input = s.toCharArray();

        // DP solution
        // m[i] stores the min cut of input[0...i - 1]
        int[] m = new int[input.length + 1];
        // i iterate index of big left part
        for (int i = 1; i <= input.length; i++){
            m[i] = Integer.MAX_VALUE;
            if (isPalindrome(input, 0, i-1)){
                // no cut is needed
                m[i] = 0;
            } else {
                // j is where the last cut is
                for (int j = 1; j < i; j++){
                    if (isPalindrome(input, j, i-1)){
                        m[i] = Math.min(m[i], m[j] + 1);
                    }
                }
            }
        }
        return m[input.length];
    }

    private boolean isPalindrome(char[]s,int i, int j ){
        if (i >= j){
            return true; // why?
        }
        while (i < j){
            if(s[i++] != s[j--]) {
                return false;
            }
        }
        return true;
    }
}
