public class removeSpace {
    public String removeSpaces(String input) {
        // sanity check
        if (input.isEmpty()){
            return input;
        }

        int s = 0;
        int f = 0;
        char[] array = input.toCharArray();

        while (f < array.length){
            // remove the leading space
            // remove duplicate spaces
            if (array[f] == ' ' && (f == 0 || array[f - 1] == ' ')){
                f++;
            } else {
                array[s++] = array[f++];
            }
        }

        // remove trailing space
        if (s > 0 && array[s - 1] == ' '){
            s--;
        }

        return new String(array, 0, s);
    }
}
