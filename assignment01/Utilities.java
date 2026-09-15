import java.util.Arrays;

public class Utilities {

    private static int count = 0;

    public static String listMeasure(Measurable m) {

        count++;
        String measure = count + " : " + m.getMeasure();
        return measure;
    }

    public static double[] getKlargest(Measurable[] mList, int k) {

        if (k < 1)
            return null;

        double[] measure_arr = new double[mList.length]; // array containing all total scores

        for (int i = 0; i < mList.length; i++) {
            measure_arr[i] = mList[i].getMeasure();
        }

        Arrays.sort(measure_arr); // sorting the array

        int ind = 0;
        double[] biggest = new double[k];

        for (int i = measure_arr.length - 1; i >= 0 && ind < k; i--) {
            biggest[ind] = measure_arr[i];
            ind++;
        }

        for (int i = ind; i < k; i++) { // implementing the d<k case
            biggest[i] = 0;
        }
        return biggest;
    }
}
