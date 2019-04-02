package hw24;

import org.omg.CORBA.INTERNAL;


import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> ages = new PrimitiveMapImpl<>();
        StringBuilder s = new StringBuilder(10);
        Random random = new Random();
        int k;
        StringBuilder stringBuilder = new StringBuilder(10);
        for (int i = 0; i < 100; i++) {
            stringBuilder = new StringBuilder(10);
            for (int j = 0; j < 3; j++) {
                do {
                    k = random.nextInt(123);
                } while (k < 97);
                stringBuilder.append((char)k);
            }
            ages.put(stringBuilder.toString(), i);
        }


        ((PrimitiveMapImpl<String, Integer>) ages).show();
    }
}
