import java.util.*;
// 1. static NeighborFinder:
//      field Map<String, Integer> wordIndex
//      field List<String> words
//      constructor NeighborFinder
//      function findNeighbors(int i)
//
// 2. static Tracer
//      field List<String> words
//      field List<List<String>> preds
//      constructor Tracer
//      function addPredecessor --> get preds, used in find ladders
//      function findLadders + findLaddersHelper (DFS)
//
// 3. findLadders(String beginWord, String endWord, List<String> wordList)
//      prepare the word list and create a NeighborFinder instance with the word list
//      Queue to store index: initiate --> {0}
//      int[] steps: initiate --> fill with -1
//      Create a Tracer instance and add the begin word
//      while loop
//          end condition: x = endIndex, return tracer.findLadders(beginIndex, endIndex)
//          generate x's neighbors y
//              if y haven't been visited: queue.offer(y), step[y] = step[x] + 1
//              if y has been visited and step[x] + 1 = step[y] --> x is y's predecessor, update preds

public class wordLadder {

    static class NeighborFinder {
        private Map<String, Integer> wordIndex = new HashMap<>();
        private List<String> words;

        public NeighborFinder(List<String> words) {
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                wordIndex.put(word, i);
            }
            this.words = words;
        }

        public List<Integer> findNeighbors(int i) {
            List<Integer> neighbors = new ArrayList<>();
            String word = words.get(i);
            StringBuilder wordModifier = new StringBuilder(word);
            // change each character
            for (int j = 0; j < wordModifier.length(); j++) {
                char orig = word.charAt(j);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == orig) {
                        continue;
                    }
                    wordModifier.setCharAt(j, c);

                    int neighbor = wordIndex.getOrDefault(wordModifier.toString(), -1);
                    // if the word exist in the wordIndex map
                    // add the index of neighbor to the list
                    if (neighbor != -1) {
                        neighbors.add(neighbor);
                    }
                }
                wordModifier.setCharAt(j, orig);
            }
            return neighbors;
        }
    }

        static class Tracer{
            private final List<String> words;
            private final List<List<Integer>> preds;
            public Tracer(List<String> words){
                this.words = words;
                preds = new ArrayList<>(words.size());
                for (int i = 0; i < words.size(); i++){
                    preds.add(new ArrayList<>(16));
                }
            }

            public void addPredecessor(int x, int y){
                // x is y's pred
                preds.get(y).add(x);
            }

            public List<List<String>> findLadders(int beginIndex, int y){
                // y --> end Index?
                List<List<String>> ladders = new ArrayList<>();
                List<String> trace = new ArrayList<>();
                // trace start from y
                trace.add(words.get(y));
                findLaddersHelper(beginIndex, y, trace, ladders);
                return ladders;
            }

            private void findLaddersHelper(int beginIndex, int y, List<String> trace, List<List<String>> ladders){
                if (beginIndex == y){
                    List<String> ladder = new ArrayList<>(trace);
                    // reverse the order from "end to start" to "start to end"
                    Collections.reverse(ladder);
                    ladders.add(ladder);
                    return;
                }

                // start from end to start, each branch is one pred of y which stored in preds
                for (int x : preds.get(y)){
                    // add x from y's preds to the trace
                    trace.add(words.get(x));
                    // do the recursion
                    findLaddersHelper(beginIndex, x, trace, ladders);
                    // delete
                    trace.remove(trace.size() - 1);
                }
            }
        }

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
            // corner case if the endWord is not in the wordList, just return an empty list
            int endIndex = wordList.indexOf(endWord);
            if (endIndex == -1){
                return new ArrayList<>();
            }

            // prepare words as the input of NeighborFinders
            List<String> words;
            int beginIndex = wordList.indexOf(beginWord);
            // if begin word does not exist in the wordList, add it
            if (beginIndex == -1){
                words = new ArrayList<>(wordList);
                words.add(beginWord);
                beginIndex = words.size() - 1;
            } else {
                words = wordList;
            }

            // Initiate one instance of NeighborFinder class with the input words
            NeighborFinder finder = new NeighborFinder(words);

            Queue<Integer> queue = new ArrayDeque<>();
            int[] step = new int[words.size()];
            Arrays.fill(step, -1);

            queue.offer(beginIndex);
            step[beginIndex] = 0;
            Tracer tracer = new Tracer(words);
            while(!queue.isEmpty()){
                int x = queue.poll();
                if (x == endIndex){
                    return tracer.findLadders(beginIndex, endIndex);
                }
                for (int y : finder.findNeighbors(x)){
                    if (step[y] == -1){
                        queue.offer(y);
                        step[y] = step[x] + 1;
                    }
                    if (step[x] + 1 == step[y]){
                        tracer.addPredecessor(x, y);
                    }
                }
            }
            return new ArrayList<>();
        }
}
