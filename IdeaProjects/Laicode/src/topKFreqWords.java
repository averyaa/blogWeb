import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFreqWords {
    public String[] topKFrequent(String[] combo, int k) {
        // assume combo is not null
        //  so we only need to consider the the case that combo.length == 0
        // combo is not guaranteed to be sorted
        //  so if k > num of distinct words, we can not output combo directly

        // sanity check
        if (combo.length == 0){
            return new String[0];
        }

        // build a map to store the distinct string and their freq
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        buildHashTable(map, combo, k);

        // build the minHeap in size k
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,
                new Comparator<Map.Entry<String, Integer>>(){
                    @Override
                    // compare the Map entries
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                        return o1.getValue().compareTo(o2.getValue());
                    }
                });

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (minHeap.size() < k){
                minHeap.offer(entry);
            }
            else if(entry.getValue() > minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        // use minHeap.size() rather than k,
        // since it is possible for k to be larger than the number of distinct string in combo,
        // in this case, just output the distinct words, which means that minHeap.size() < k
        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--){
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }

    private void buildHashTable(HashMap<String, Integer> map, String[] combo, int k){
        for (int i = 0; i < combo.length; i++){
            if (!map.containsKey(combo[i])){
                map.put(combo[i], 1);
            } else {
                map.put(combo[i], map.get(combo[i]) + 1);
            }
        }
    }

}
