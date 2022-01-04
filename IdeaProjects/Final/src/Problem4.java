public class Problem4 {
    public boolean canChain(String[] strArr){
        return helper(strArr, 1);
    }

    private boolean helper(String[] strArr, int index){
        // base case
        if (index == strArr.length){
            return canConnect(strArr[index - 1], strArr[0]);
        }
        for (int i = index; i < strArr.length; i++){
            if (canConnect(strArr[index - 1], strArr[i])){
                swap(strArr, index, i);
                if (helper(strArr, index + 1)){
                    return true;
                }
                swap(strArr, index, i);
            }
        }
        return false;
    }

    private boolean canConnect(String s1, String s2){
        return s1.charAt(s1.length() - 1) == s2.charAt(0);
    }

    private void swap(String[] strArr, int index, int i){
        String temp = strArr[index];
        strArr[index] = strArr[i];
        strArr[i] = temp;
    }
}
