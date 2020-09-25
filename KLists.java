import java.util.Arrays;

public class KList {
    public double[] mergeKLists (double[][] outerArray) {
        //check if empty
        if (outerArray.length == 0) {
            return new double[0];
        }

        //array to be returned
        double[] retArr = outerArray[0];
        for (int i = 1; i < outerArray.length; i++) {
            retArr = merge(retArr, outerArray[i]);
        }
        return retArr;
    }
    //merging the left and right together
    public double[] merge(double[] left, double[] right) {
        int i = 0;
        int l = 0;
        int r = 0;
        int lLen = left.length;
        int rLen = right.length;
        double[] retArr = new double[lLen + rLen];
        while(l < lLen && r < rLen){
            if (left[l] <= right[r]) {
                retArr[i] = left[l++];
            }
            else {
                retArr[i] = right[r++];
            }
            i++;
        }
        //finish left
        while(l < lLen) {
            retArr[i++] = left[l++];
        }

        //finish right
        while(r < rLen) {
            retArr[i++] = right[r++];
        }
        return retArr;
    }

    public static void main(String args[]){
        KList test = new KList();
        double [][] outerArray = {{9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27}};
        System.out.println(Arrays.toString(test.mergeKLists(outerArray)));
    }
}
