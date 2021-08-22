import java.util.*;

public class kthSmallest357 {

    public int kthSmallest357(int k){

        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>(k);

        minHeap.offer(3 * 5 * 7L);
        visited.add(3*5*7L);

        while(k > 1){
            long current = minHeap.poll();
            // <x+1, y, z> ==> cur*3
            if (visited.add(3* current)){
                minHeap.offer(3*current); // O(logk)
            }

            if (visited.add(5*current)){
                minHeap.offer(5*current);
            }

            if (visited.add(7*current)){
                minHeap.offer(7*current);
            }
            k--;
        }

        Long result = minHeap.peek();


        return Math.toIntExact(result);

    }
}

//TC: O(klogk)
//SC: O(k)
