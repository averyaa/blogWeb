import java.util.*;
// main function putChair(char[][] gym)
//      M, N
//      int[][] cost
//      case 1: if one EQUIP never been reached
//      for for loop
//         if EQUIP if addCost(cost, gym, i, j) == false --> no result
//      case 2: find the shortest path
//      for for loop
//          if not E, not Q
//              result = i, j
//          else if cost[i][j] < cost[result.get(0)][result.get(1)]
//              set result ==> i, j
//
// helper function boolean addCost(int[][] cost, char[][] gym, int i, int j)
//      BFS
//      boolean visited
//      int pathCost = 1
//      Queue<Pair>
//      while !queue.isEmpty()
//      ....
//      for for loop
//          if gym[i][j] == E && !visited[i][j] --> return false
// helper function List<Pair> getNeis(Pair cur, char[][] gym)
//      up down right left, if not out of bound and not OB, add to List<Pair> neis
// static class Pair
public class placeToPutTheChair {
    private static final char EQUIP = 'E';
    private static final char OB = 'O';

    public List<Integer> putChair(char[][] gym) {
        // Assumptions: gym is not null, has size M * N
        // where M >= 1 and N >= 1
        // return null if you can not put the chair anymore
        // there is at least one equipment in the gym
        int M = gym.length;
        int N = gym[0].length;
        // use a matrix to record the sum of shortest path cost
        // from each cell to all the 'E' cells

        int[][] cost = new int[M][N];
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (EQUIP == gym[i][j]){
                    //use BFS to calculate the shortest path cost from
                    //each of the equipments to all the other reachable cells
                    //and add the cost to each corresponding cell
                    //Note the return boolean value represents if there exists
                    //another 'E' cell not reachable from the current one
                    //if so, there won't exist a cell to place the chair
                    if (!addCost(cost, gym, i, j)){
                        return Arrays.asList(-1, -1);
                    }
                }
            }
        }


        // find the cell with smallest sum of shorst path costs
        // to all the 'E' cells
        List<Integer> result = null;

        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (EQUIP != gym[i][j] && OB != gym[i][j]){
                    if (result == null){
                        result = Arrays.asList(i, j);
                    } else if (cost[i][j] < cost[result.get(0)][result.get(1)]){
                        result.set(0, i);
                        result.set(1, j);
                    }
                }
            }
        }
        if (result == null){
            return Arrays.asList(-1, -1);
        }
        return result;
    }

    private boolean addCost(int[][] cost, char[][] gym, int i, int j){
        // use a boolean matrix to make sure each cell will be visited
        // no more than once
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        // Bread-First-Search, record the current path cost
        int pathCost = 1;
        Queue<Pair> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.offer(new Pair(i, j));
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int l = 0; l < size; l++){
                Pair cur = queue.poll();
                List<Pair> neis = getNeis(cur, gym);
                for (Pair nei : neis){
                    if (!visited[nei.i][nei.j]){
                        visited[nei.i][nei.j] = true;
                        cost[nei.i][nei.j] += pathCost;
                        queue.offer(nei);
                    }
                }
            }
            pathCost++;
        }

        // if there exists another 'E' cell not reachable from
        // the path start 'E' cell, we return false
        for (int l = 0; l < gym.length; l++){
            for (int m = 0; m < gym[0].length; m++){
                if (!visited[l][m] && EQUIP == gym[l][m]){
                    return false;
                }
            }
        }
        return true;
    }

    private List<Pair> getNeis(Pair cur, char[][] gym){
        int x = cur.i;
        int y = cur.j;
        int M = gym.length;
        int N = gym[0].length;
        List<Pair> neis = new ArrayList<>();

        if (x + 1 < M && OB != gym[x + 1][y]){
            neis.add(new Pair(x + 1, y));
        }

        if (y + 1 < N && OB != gym[x][y + 1]){
            neis.add(new Pair(x, y + 1));
        }

        if (x - 1 >= 0 && OB != gym[x - 1][y]){
            neis.add(new Pair(x - 1, y));
        }

        if (y - 1 >= 0 && OB != gym[x][y - 1]){
            neis.add(new Pair(x, y - 1));
        }
        return neis;
    }

    static class Pair{
        int i;
        int j;

        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
