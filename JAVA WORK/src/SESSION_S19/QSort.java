package SESSION_S19;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QSort {

    static int[] qsort(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }
        if (i < right) qsort(arr, i, right);
        if (left < j) qsort(arr, left, j);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 3, 7, 3, 8, 0, 5, 4, 6};
        qsort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


}
