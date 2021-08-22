import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class maxKSlidingWindows {
    public List<Integer> maxWindows(int[] array, int k) {
        // deque stores index
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            // discard any index with smaller value than index i
            while(!deque.isEmpty() && array[deque.peekLast()] <= array[i]){
                deque.pollLast();
            }
            // push i into the deque
            deque.offerLast(i);

            // check the size of sliding window, make sure it is k
            // it is possible the head element is out of the current
            // sliding window so we might need to discard it as well
            if(!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.pollFirst();
            }

            // check if the first sliding window is full
            if(i >= k - 1){
                // deque.peekFirst is the max value index in the last sliding window
                max.add(array[deque.peekFirst()]);
            }
        }
        return max;
    }
}
