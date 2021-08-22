public class stringAbbreviation {
    public boolean match(String input, String pattern) {
        // Write your solution here
        if (input.length() == 0 && pattern.length() == 0){
            return true;
        }
        if (input.length() == 0 || pattern.length() == 0){
            return false;
        }
        int ii = 0;
        int pi = 0;

        while(ii <= input.length()){
            // case 1: if the indexes of input and pattern reach to the end at the same time, true
            if (ii == input.length() && pi == pattern.length()){
                return true;
            }
            // case 2: if pi reach to the end first, return false
            else if (ii == input.length() || pi >= pattern.length()){
                return false;
            }

            // case 3: pattern.charAt(pi) is digit, get the count
            else if(Character.isDigit(pattern.charAt(pi))){
                int count = 0;
                while(pi < pattern.length() && Character.isDigit(pattern.charAt(pi))){
                    count *= 10;
                    count += (pattern.charAt(pi) - '0');
                    pi++;
                }
                ii += count; // book b3 ii from 0 to 3
            }
            // case 4: pattern.charAt(pi) is not digit and is not the same with input.charAt(ii)
            else if(pattern.charAt(pi) != input.charAt(ii)){
                return false;
            }
            // case 5: pattern.charAt(pi) is not digit and is the same with input.charAt(ii), ii++, pi++;
            else if(pattern.charAt(pi) == input.charAt(ii)){
                pi++;
                ii++;
            }
        }
        return false;
    }
}
