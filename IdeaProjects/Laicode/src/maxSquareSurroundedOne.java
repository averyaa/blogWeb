public class maxSquareSurroundedOne {
    public int largestSquareSurroundedByOne(int[][] matrix) {
        // Write your solution here
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 0 || cols == 0) return 0;

        int[][] left = leftLook(matrix, rows, cols);
        int[][] up = upLook(matrix, rows, cols);
        int maxLen = Integer.MIN_VALUE;

        for (int i = rows - 1; i > 0; i--){
            for (int j = cols - 1; j > 0; j--){
                for (int side = rows; side > 0; side--){
                    if (i - side + 1 >= 0 && j - side + 1 >= 0) {
                        if (left[i][j] >= side && left[i - side + 1][j] >= side &&
                                up[i][j] >= side && up[i][j - side + 1] >= side) {
                            maxLen = Math.max(maxLen, side);
                        }
                    }
                }
            }
        }

        return maxLen;
    }


    private int[][] leftLook(int[][] matrix, int rows, int cols){
        int[][] left = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (matrix[i][j] == 1){
                    if (j == 0){
                        left[i][j] = 1;
                    } else {
                        left[i][j] = left[i][j - 1] + 1;
                    }
                }
            }
        }
        return left;
    }

    private int[][] upLook(int[][] matrix, int rows, int cols){
        int[][] up = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (matrix[i][j] == 1){
                    if (i == 0){
                        up[i][j] = 1;
                    } else {
                        up[i][j] = up[i - 1][j] + 1;
                    }
                }
            }
        }
        return up;
    }
}
