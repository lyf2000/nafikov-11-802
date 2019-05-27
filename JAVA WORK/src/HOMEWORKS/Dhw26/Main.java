package HOMEWORKS.Dhw26;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int mainSum;

    static {
        mainSum = 0;
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        MyThread[] myThreads;

        int num_of_values;
        int num_of_threads;

        int[] array;

        System.out.println("Enter num of values: ");
        num_of_values = scanner.nextInt();
        array = new int[num_of_values];

        System.out.println("Enter num of threads: ");
        num_of_threads = scanner.nextInt();
        myThreads = new MyThread[num_of_threads];

        int executedSum = 0;
        for (int i = 0; i < num_of_values; i++) {
            array[i] = random.nextInt(1000);
            executedSum += array[i];
        }

        int entire = num_of_values / num_of_threads;
        int rest = num_of_values - num_of_threads * entire;
        boolean hasRest = rest != 0;
        if (hasRest) {
            if ((rest >= entire / 2)) {
                entire++;
                num_of_threads--;
            }
        }
        for (int i = 0; i < num_of_threads; i++) {
            myThreads[i] = new MyThread(i * entire, (i + 1) * entire, array);
            myThreads[i].run();
            myThreads[i].join();
        }
        if (hasRest) {
            myThreads[num_of_threads] = new MyThread(entire * num_of_threads, num_of_values, array);
            myThreads[num_of_threads].run();
            myThreads[num_of_threads].join();
        }

        System.out.println(executedSum == mainSum);
    }
}
