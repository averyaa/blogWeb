import java.util.Comparator;
import java.util.PriorityQueue;

public class kSmallestSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        //assume the matrix if not null, N > 0 and M > 0
        //assume k > 0 && k <= N * M

        int rows = matrix.length;
        int cols = matrix[0].length;

        // create a k size minHeap
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, (o1, o2) -> {
            if (o1.value == o2.value) return 0;
            return o1.value < o2.value ? -1 : 1;
        });

        // initialize
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        // use matrix visited to keep track if the node is visited or not
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;

        // do k times of iteration
        for (int i = 0; i < k - 1; i++){
            // pop the cur min cell
            Cell cur = minHeap.poll();

            // add the left and bottom neighbour of this cell to the minHeap
            if (cur.row + 1 < rows && !visited[cur.row + 1][cur.col]) {
                minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
                visited[cur.row + 1][cur.col] = true;
            }
            if (cur.col + 1 < cols && !visited[cur.row][cur.col + 1]) {
                minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
                visited[cur.row][cur.col + 1] = true;
            }
        }

        // after kth iteration, the top of the minHeap would be the kth smallest element in the sorted matrix
        return minHeap.peek().value;
    }


    static class Cell{
        int row;
        int col;
        int value;

        Cell(int row, int col, int value){
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
