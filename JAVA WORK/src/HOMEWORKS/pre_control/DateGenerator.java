package HOMEWORKS.pre_control;

import java.util.Random;

public class DateGenerator {
    static Random random = new Random();
    static String[] getDates(int num){

        String[] strings = new String[num];

        for (int i = 0; i < num; i++){
            strings[i] = (Math.abs(random.nextInt()%31 + 1) + "." + Math.abs(random.nextInt()%12 + 1)
                    + "." +
                    Math.abs(random.nextInt()%9999 + 1));
        }
        return strings;
    }
}
