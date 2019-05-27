package CODEFORCES.task733D;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;

class MySet {

    private int id;
    private int min;
    private ArrayList<Integer> arrayList;

    MySet() {
        arrayList = new ArrayList(3);
    }

    public void add(int a, int b, int c){
        int v1 = a * b;
        int v2 = a * c;
        int v3 = b * b;
        min = Math.min(a, Math.min(b, c));

        arrayList.add(v1);
        if (v1 != v2) {
            arrayList.add(v2);
            if (v1 != v3 && v3 != v2) {
                arrayList.add(v3);
            }
        } else {
            if (v1 != v3) {
                arrayList.add(v3);
            }
        }
    }

}

public class Main {

    public static void main(String[] args) {
        int n = 10;

        MySet[] mySets = new MySet[n];
        for (int i = 0; i < n; i++) {
            mySets[i].add(1, 2, 3);
        }
    }
}
