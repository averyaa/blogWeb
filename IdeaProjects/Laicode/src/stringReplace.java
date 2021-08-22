import java.util.Arrays;

public class stringReplace {
    public String replace(String input, String source, String target) {
        // case 1: if f is not a start of source, a[s] = a[f], s++, f++
        // case 2: if f is a start of the source, f += target.length, copy target into a[s]

        // what if target is longer than source?
        // 1. scan once and find out the # of occurences of source
        // 2. increase the length by "# of occurences" * (target.length() - source.length())

        // sanity check
        if (input.length() == 0){
            return input;
        }

        // 1. scan
        int count = 0;
        char[] array = input.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == source.charAt(0)){
                if(isMatch(array, i, source)){
                    count++;
                }
            }
        }

        // 2. increase the length
        int newLength = input.length();
        if (target.length() > source.length()){
            newLength += count * (target.length() - source.length());
        }
        char[] result = new char[newLength];

        // 3. start the replacement
        int f = 0;
        int s = 0;
        while (f < array.length){
            if (array[f] == source.charAt(0) && isMatch(array, f, source)){
                for (int i = 0; i < target.length(); i++){
                    result[s + i] = target.charAt(i);
                }
                s += target.length();
                f += source.length();
            } else {
                result[s] = array[f];
                s++;
                f++;
            }
        }
        char[] resultCut = Arrays.copyOfRange(result, 0, s);
        return new String(resultCut);
    }

    private boolean isMatch(char[] array, int f, String source){
        for (int i = 0; i < source.length(); i++){
            if ((f + i) > array.length - 1 || array[f + i] != source.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
