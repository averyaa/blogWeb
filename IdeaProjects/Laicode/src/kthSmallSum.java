import java.util.Comparator;
import java.util.PriorityQueue;

public class kthSmallSum {
    public int solution(int k, int[] A, int[] B){

        // clarify
        if (A == null && B == null) return 0;
        // what if A == null or B == null??

        // create a k-size maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                return o2.compareTo(o1);
                //if (o1 == o2) return 0;
                //return o1 > o2 ? -1: 1;
            }
        });

        int count = 0;

        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                int s = A[i] + B[j];
                count++;
                if (count <= k) {
                    maxHeap.offer(s);
                } else  if (count > k && s < maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.offer(s);
                }
            }
        }

        return maxHeap.poll();

    }
}
