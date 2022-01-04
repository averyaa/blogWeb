public class BreakContinue {
    public static void windowPosSum(int[]a, int n){
        for (int i = 0; i < a.length; i++){
            if (a[i] >= 0){
                for (int j = 0; j <= n; j++){
                    a[i] += a[i+j];
                }




            }
        }



    }

}
