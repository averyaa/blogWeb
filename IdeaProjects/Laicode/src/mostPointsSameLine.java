import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mostPointsSameLine {
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int mostPointsSameLine(Point[] input){

        int result = 0;

        for (int i = 0; i < input.length; i++){
            Point seed = input[i];
            // record the points with same <x, y>
            int same = 1;
            // record the points with x, infinite slope
            int sameX = 0;
            // record the maximum number of points on the same line crossing the seed
            int most = 0;
            // a map for all possible slope
            HashMap<Double, Integer> cnt = new HashMap<Double, Integer>();
            for (int j = 0; j < input.length; j++){
                if (i == j){
                    continue;
                }

                Point tmp = input[j];
                if (tmp.x == seed.x && tmp.y == seed.y){
                    // handle the points with same <x, y>
                    same++;
                } else if (tmp.x == seed.x){
                    // handle the infinite slope
                    sameX++;
                } else {
                    // otherwise, just calculate the slope and increment the counter
                    // for the calculated slope
                    double slope = ((tmp.y - seed.y) + 0.0) / (tmp.x - seed.x);
                    if (!cnt.containsKey(slope)){
                        cnt.put(slope, 1);
                    } else {
                        cnt.put(slope, cnt.get(slope) + 1);
                    }
                    most = Math.max(most, cnt.get(slope));

                }
            }
            most = Math.max(most, sameX) + same;
            result = Math.max(result, most);
        }
        return result;
    }
}
