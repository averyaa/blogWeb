import java.util.*;

public class kthClosestTo000 {
    public List<Integer> kthClosestTo000(final int[] a, final int[] b, final int[] c, int k){
        // Assumptions: a, b, c are not null, length >= 1
        // k >= 1 && k < a.length * b.length * c.length
        // minHeap, compare the distance
        // List<Integer> -> i, j, m index of a, b, c

        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>(){
        @Override
        public int compare(List<Integer> o1, List<Integer> o2){
             long d1 = distance(o1, a, b ,c);
             long d2 = distance(o2, a, b ,c);
             if (d1 == d2){
                 return 0;
             }
             return d1 < d2 ? -1 : 1;
         }
        });

        Set<List<Integer>> visited = new HashSet<>();

        // start from index = 0, 0, 0
        List<Integer> cur = Arrays.asList(0, 0, 0);
        visited.add(cur);
        minHeap.offer(cur);

        while(k > 0){
            cur = minHeap.poll();
            List<Integer> n = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
            if (n.get(0) < a.length && visited.add(n)){
                minHeap.offer(n);
            }

            n = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
            if (n.get(1) < b.length && visited.add(n)){
                minHeap.offer(n);
            }

            n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
            if (n.get(2) < c.length && visited.add(n)){
                minHeap.offer(n);
            }
            k--;
        }

        // replace the index with actual values in a, b, c
        cur.set(0, a[cur.get(0)]);
        cur.set(1, b[cur.get(1)]);
        cur.set(2, c[cur.get(2)]);

        return cur;
    }


    private long distance(List<Integer> o1, int[] a, int[] b, int[] c){
        long dis = 0;
        int x = a[o1.get(0)];
        int y = b[o1.get(1)];
        int z = c[o1.get(2)];

        // DO NOT use (long)Math.sqrt!!!
        // Math.sqrt(18) = 4
        // Math.sqrt(24) = 4
        dis = x*x + y*y + z*z;

        return dis;
    }
}
