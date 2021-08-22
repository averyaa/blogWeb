import java.util.Comparator;
import java.util.PriorityQueue;

public class kSmallUnsortedArray {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        // maxheap approach
        // assumptions: array is not null, k >= 0 and <= the size of array

        // corner case:
        if (array.length == 0 || k == 0){
            return new int[0];
        }


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                // do not use o1 == o2!!!!
                if (o1.equals(o2)) return 0;
                return o1 > o2 ? -1 : 1;
                // or just use
                // return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < array.length; i++){
            // i start from 0, so use i < k, no =
            if (i < k){
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }

        int[] result = new int[k];
        for (int j = k - 1; j >= 0; j--){
            result[j] = maxHeap.poll();
        }
        return result;

    }
}
