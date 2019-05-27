import java.util.Arrays;

public class Exp {
    public static void main(String[] args) {
        int[] a = {10, 22, 3, 13};
        int n = a.length;
        for (int i = 0; i < n-1; i++)
            for (int j = i+1; j < n; j++)
                if (a[i]>a[j]) {
                    int x = a[i];
                    a[i] = a[j];
                    a[j] = x;
                }
        System.out.println(Arrays.toString(a));
    }
}
