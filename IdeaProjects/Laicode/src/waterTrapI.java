public class waterTrapI {
    public int waterTrap(int[] input){
        int i = 0;
        int j = input.length - 1;
        int left = input[i];
        int right = input[j];

        int result = 0;

        while(i < j){
            left = Math.max(left, input[i]);
            right = Math.max(right, input[j]);

            if (left < right) {
                result += (left - input[i]);
                i++;
            } else {
                result += (right - input[j]);
                j--;
            }
        }
        return result;
    }
}
