import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class majorNumberII {
    public List<Integer> majorityElement(int[] nums) {
        // more than n/3 times --> candidates
        // case 1: count1/2 = 0, first appear --> candidate1/2 to n, count1/2++
        // case 2: candidate is not null, and nums[i] == candidate, count++
        // case 3: nums[1] != candidate, count1/2--;
        int count1 = 0;
        int count2 = 0;
        Integer candidate1 = null;
        Integer candidate2 = null;

        for (int n : nums){

            // first check if the candidates already been set
            if (candidate1 != null && candidate1 == n){
                count1++;
            }
            else if (candidate2 != null && candidate2 == n){
                count2++;
            }
            // then set the candidates, otherwise there might be duplicate candidates
            else if (count1 == 0){
                candidate1 = n;
                count1++;
            }
            else if (count2 == 0){
                candidate2 = n;
                count2++;
            }

            else {
                count1--;
                count2--;
            }
        }

        // check the appear times of two candidates > n/3 or not
        List<Integer> result = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int n : nums){
            if (candidate1 != null && n == candidate1){
                count1++;
            }
            if (candidate2 != null && n == candidate2){
                count2++;
            }
        }

        int len = nums.length;
        if (count1 > len/3) result.add(candidate1);
        if (count2 > len/3) result.add(candidate2);

        return result;

    }
}
