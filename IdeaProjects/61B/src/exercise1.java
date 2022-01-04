public class exercise1 {
    public static int max(int[] m) {
        int max = 0;
        for (int i = 0; i < m.length; i++){
            if (m[i] > max) {
                max = m[i];
            }
        }

        return max;
    }

}
