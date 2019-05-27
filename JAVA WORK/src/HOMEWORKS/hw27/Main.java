package HOMEWORKS.hw27;

import HOMEWORKS.hw27.Tree.TreeImpl;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        TreeImpl tree = new TreeImpl();
        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            tree.insert(random.nextInt(15));
        }
        tree.print();
//        System.out.println(tree.getHeight();

    }
}
