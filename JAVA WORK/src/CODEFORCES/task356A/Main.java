package CODEFORCES.task356A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void round(int l, int r, String kn) {
        for (int i = l; i <= r; i++) {
            if (knights[i - 1] == null && !kn.equals(i+"")) {
                knights[i - 1] = kn;
            }
        }
    }


    static String[] knights;
    static String r;
    static int n;
    static String[] q;

    static String[] getSplit(int n, char spl) {
        char[] ch = r.toCharArray();
        int index = r.indexOf(' ');
        StringBuilder w;

        String[] s = new String[n];
        int k = 0;
        for (int i = 0; i < n - 1; i++) {
            w = new StringBuilder();
            while (k < index) {
                w.append(ch[k++]);
            }
            s[i] = (w.toString());
            k++;
            index = r.indexOf(spl, k);
        }
        w = new StringBuilder();
        if (index == -1) index = ch.length;
        while (k < index) {
            w.append(ch[k++]);
        }
        s[n-1] = w.toString();
        return s;

    }

    static void notNull() {
        for (int i = 0; i < n; i++) {
            if (knights[i] == null){
                knights[i] = "0";
                break;
            }
        }
    }

    static void show() {
        notNull();
        for (int i = 0; i < n; i++) {
            System.out.print(knights[i] + " ");
        }
    }


    public static void main(String[] args) {

        int k;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            r = br.readLine();
            q = getSplit(2, ' ');
            n = Integer.parseInt(q[0]);
            k = Integer.parseInt(q[1]);


            knights = new String[n];

            for (int i = 0; i < k; i++) {
                r = br.readLine();
                q = getSplit(3, ' ');
                round(Integer.parseInt(q[0]), Integer.parseInt(q[1]), q[2]);
            }

            show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
