public class LeetCode {
    /**public boolean validPalindrome(String s){
        if (ifPalindrome(s)){
            return true;
        }else{
            for (int i = 0; i < s.length(); i++){
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                if (ifPalindrome(sb.toString()) == false){
                    return false;
                } else {
                    continue;
                }
            }
            return true;
        }

    }


    private boolean ifPalindrome(String s){
        int len = s.length();
        int mid = len / 2;

        if (len % 2 == 0){
            int left = mid - 1;
            int right = mid;
            while (left >= 0 && right < len){
                if (s.charAt(left) != s.charAt(right)){
                    return false;
                }else {
                    left--;
                    right++;
                }
            }
        }

        if (len % 2 != 0){
            int left = mid - 1;
            int right = mid + 1;
            while (left >= 0 && right < len){
                if (s.charAt(left) != s.charAt(right)){
                    return false;
                }else {
                    left--;
                    right++;
                }
            }
        }

        return true;
    }**/

    public boolean isPalindromeRange(String s, int i , int j){
        for (int k = i; k <= i + (j - i) / 2; k++){
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }

    public boolean validPalindrome(String s){
        for (int i = 0; i < s.length() / 2; i++){
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i+1, j) ||
                        isPalindromeRange(s, i, j-1));
            }
        }

        return true;
    }

}
