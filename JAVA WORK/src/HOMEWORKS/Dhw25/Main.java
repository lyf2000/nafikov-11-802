package HOMEWORKS.Dhw25;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Human> humans = FrameWork.getObjects(10, Human.class, "qwe", 19);

        for (Human h : humans) {
            System.out.println(h.getFirst_name() + " " +h.getLast_name() + " " + h.getAge());
        }
//        for (Human human : humans) {
//            System.out.println(human.getFirst_name() + " " + human.getLast_name() + " " + human.getAge());
//        }

    }
}
