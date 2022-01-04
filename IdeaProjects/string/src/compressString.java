public class compressString {
    public String compress(String input) {
        // Write your solution here
        if (input == null || input.length() == 0){
            return input;
        }

        char[] array = input.toCharArray();
        return encode(array);
    }

    private String encode(char[] input){

        // adjacent occurrence of the letters >= 2, only the letter is copies, not the num?
        int slow = 0;
        int fast = 0;
        int newLength = 0;
        while(fast < input.length){
            int begin = fast;
            // move the fast pointer until it does not equal to begin
            while (fast < input.length && input[fast] ==  input[begin]){
                fast++;
            }
            // copy the letter
            input[slow++] = input[begin];
            // if there is only one letter
            if (fast - begin == 1){
                newLength += 2;
            } else {
                // get the length of the same letters
                int len = copyDigits(input, slow, fast - begin);
                // move the slow pointer according to num of digits ('11' --> 2, '1'--> 1)
                slow += len;
                // len + 1(letter' position)
                newLength += len + 1;
            }
        }

        // reversely copy the inputarray to result array. if it is digit, copy, if it is not digit (which means
        // the letter only appear once, copy '1'., then copy the letter.
        char[] result = new char[newLength];
        fast = slow - 1;
        slow = newLength - 1;
        while (fast >= 0){
            // deal with the number
            if (Character.isDigit(input[fast])){
                while (fast >= 0 && Character.isDigit(input[fast])){
                    result[slow--] = input[fast--];
                }
            } else {
                result[slow--] = '1';
            }
            // copy the letter
            result[slow--] = input[fast--];
        }
        return new String(result);
    }

    private int copyDigits(char[] input, int index, int count){
        int len = 0;
        for (int i = count; i > 0; i /= 10){
            index++;
            len++;
        }
        for (int i = count; i > 0; i /= 10){
            int digit = i % 10;
            // copy the number from the unit to decade
            input[--index] = (char)('0' + digit);
        }
        return len;
    }

}

