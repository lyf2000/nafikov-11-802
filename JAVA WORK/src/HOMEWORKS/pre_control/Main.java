package HOMEWORKS.pre_control;

import java.util.Arrays;

public class Main {

    static String[] dates;
    static int num = 10;

    public static void main(String[] args) {
        getDates();
        showDates();
        separateDate(0);
        System.out.println("qwerty".substring(2));
    }

    private static boolean isGoodDate() {


        return false;
    }

    private static int[] separateDate(int date_index) {
        int[] nums = new int[3];
        int first_point_index, last_point_index;
        first_point_index = dates[date_index].indexOf('.');
        last_point_index = dates[date_index].lastIndexOf('.');
        nums[0] = Integer.parseInt(dates[date_index].substring(0, first_point_index));
        nums[1] = Integer.parseInt(dates[date_index].substring(first_point_index + 1, last_point_index));
        nums[2] = Integer.parseInt(dates[date_index].substring(last_point_index));

        System.out.println(Arrays.toString(nums));

        return null;
    }

    private static void getDatesInRange(int left, int right) {

    }

    private static void showDates() {
        for (int i = 0; i < num; i++) {
            System.out.println(dates[i]);
        }
    }

    private static void getDates() {
        dates = DateGenerator.getDates(num);
    }
}
