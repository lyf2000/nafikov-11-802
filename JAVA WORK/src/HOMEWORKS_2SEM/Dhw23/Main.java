package HOMEWORKS_2SEM.Dhw23;


import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int STRING_LENGTH = 10;
        final int NUM_OF_STRINGS = 100;
        Map<String, Integer> ages = new PrimitiveMapImpl<>();
        Random random = new Random();
        int k;
        StringBuilder stringBuilder;
        for (int i = 0; i < NUM_OF_STRINGS; i++) {
            stringBuilder = new StringBuilder(STRING_LENGTH);
            for (int j = 0; j < STRING_LENGTH; j++) {
                do {
                    k = random.nextInt(150);
                } while (!(k >= 'A' && k <= 'Z' || k >= 'a' && k <= 'z'));
                stringBuilder.append((char) k);
            }

            System.out.println(stringBuilder);
            ages.put(stringBuilder.toString(), i);
        }


        ((PrimitiveMapImpl<String, Integer>) ages).show();
    }
}
