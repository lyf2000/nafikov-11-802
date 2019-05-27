package SESSION_S19;

import java.util.Arrays;
import java.util.Random;

public class BinaryHeap {

    static int[] tree = new int[100];
    static int size = 0;

    static void swap(int i, int j) {
        int x = tree[i];
        tree[i] = tree[j];
        tree[j] = x;
    }

    static void add(int x) {
        tree[size] = x;
        size++;
        int i = size - 1;
        while (i != 0 && tree[i] < tree[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    static int pow(int x, int i) {
        int a = 1;
        while (i > 0) {
            a *= x;
            i--;
        }
        return a;
    }

    static void showTree() {
        int height = (int) (Math.log(size) / Math.log(2));
        for (int i = 0; i < height; i++) {
            int p = pow(2, i);
            int x = p - 1;
            for (int j = 0; j < p; j++) {
                System.out.print(tree[x++] + " ");
            }
            System.out.println();
        }
    }

    static void deleteMin() {
        int ans = tree[0];
        swap(0, size-1);
        size--;
        int i = 0, m = 2 * i + 1;
        if (m + 1 < size && tree[m] > tree[m + 1]) m++;
        while (2 * i < size && tree[i] > tree[m]) {
            swap(i, m);
            m = 2 * i + 1;
            if (m + 1 < size && tree[m] > tree[m + 1]) m++;
        }

    }

    public static void main(String[] args) {

        Random random = new Random();
        for (int i = 0; i < 55; i++) {
            add(random.nextInt(100));
        }
        showTree();
        add(-10);
        System.out.println();
        showTree();
        deleteMin();
        System.out.println();
        showTree();
        deleteMin();
        System.out.println();
        showTree();


    }
}
