public class Problem3 {
    public int minimumBox(int swag){
        int[] dp = new int[swag + 1];
        dp[0] = 0;
        for (int i = 1; i <= swag; i++){
            dp[i] = i;
            for (int sqrt = 1; sqrt * sqrt <= i; sqrt++){
                dp[i] = Math.min(dp[i], dp[i - sqrt * sqrt] + 1);
            }
        }
        return dp[swag];
    }
}
