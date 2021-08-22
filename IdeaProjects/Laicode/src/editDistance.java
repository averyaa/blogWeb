public class editDistance {
    public int editDistance(String one, String two) {
        // sign
        // asith
        // if one.charAt(i) == two.charAt(j) do nothing
        // 1.replace
        //   s ign
        //   a sith
        //   1 + M[i - 1][j - 1]
        // 2.delete
        //   s ign
        //     asith
        //   1 + M[i - 1][j]
        // 3.insert
        //     a sign
        //     a sith
        //   1 + M[i][j - 1]

        // assumption: noth strings are not null
        int[][] dp = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
