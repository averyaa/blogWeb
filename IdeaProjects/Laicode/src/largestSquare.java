public class largestSquare {
    public int largest(int[][] matrix) {
        // Write your solution here
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = matrix[i][j];
                }
                else if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                }
                else if (matrix[i][j] == 1){
                    // Math.min only takes two arguments
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }

        return max;

    }
}
