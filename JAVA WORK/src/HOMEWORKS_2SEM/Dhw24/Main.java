package HOMEWORKS_2SEM.Dhw24;

import HOMEWORKS_2SEM.Dhw24.my_linked_list.MyLinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        for (int i = 0; i < 10; i++){
            myLinkedList.add(i*i - 1);
        }

        MyStream<Integer> myStream = new MyStream<>(myLinkedList);

        MyLinkedList m1 = myStream.filter(value -> value < 11).list();
        printList(m1);
        MyLinkedList m2 = myStream.map(value -> (char)(value + 32)).list();
        printList(m2);
        myStream.forEach(value -> System.out.println(value + 100));

    }

    public static <T> void printList(MyLinkedList<T> myLinkedList) {

        for (T value : myLinkedList) {
            System.out.print(value + " ");
        }
    }
}

