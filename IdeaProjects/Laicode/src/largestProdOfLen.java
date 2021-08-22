import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class largestProdOfLen {
    public int largestProduct(String[] dict) {
        // get the bitMasks to check if there is common char or not
        HashMap<String, Integer> bitMasks = getBitMasks(dict);
        // let the strings ordered descending, so the len used would start form the largest one
        Arrays.sort(dict, new Comparator<String>(){
            @Override
            public int compare(String s0, String s1){
                if (s0.length() == s1.length()){
                    return 0;
                }
                return s0.length() < s1.length() ? 1 : -1;
            }
        });

        int largest = 0;

        for(int i = 1; i < dict.length; i++){
            for (int j = 0; j < i; j++){
                // early break if the prod already smaller than the current largest one
                int prod = dict[i].length() * dict[j].length();
                if (prod <= largest){
                    break;
                }

                int iMask = bitMasks.get(dict[i]);
                int jMask = bitMasks.get(dict[j]);

                // no common char,
                // since there is not any position such that in the two bit masks they are all 1
                if ((iMask & jMask) == 0){
                    largest = prod;
                }
            }
        }
        return largest;
    }

    private HashMap<String, Integer> getBitMasks(String[] dict){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String str : dict){
            int bitMask = 0;

            for (int i = 0; i < str.length(); i++){
                // set str's k-th bit to 1, k = str.chatAt(i) - 'a'
                bitMask |= 1 << (str.charAt(i) - 'a');
            }
            map.put(str, bitMask);
        }
        return map;
    }
}
