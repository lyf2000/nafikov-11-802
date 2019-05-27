package HOMEWORKS_2SEM.Dhw24;

import HOMEWORKS_2SEM.Dhw24.my_linked_list.MyLinkedList;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {
    MyLinkedList<T> myLinkedList;

    public MyStream(MyLinkedList<T> myLinkedList) {
        this.myLinkedList = myLinkedList;
    }

    public MyStream() {
        this.myLinkedList = new MyLinkedList<>();
    }

    public MyStream<T> filter(Predicate<T> predicate) {
        MyStream<T> myStream = new MyStream<>();

        for (T value : this.myLinkedList) {
            if (predicate.test(value)) {
                myStream.myLinkedList.add(value);
            }
        }

        return myStream;
    }

    public <R> MyStream<R> map(Function<T, R> function) {
        MyStream<R> myStream = new MyStream<>();

        for (T value : this.myLinkedList) {
            myStream.myLinkedList.add(function.apply(value));
        }

        return myStream;
    }

    public void forEach(Consumer<T> consumer) {

        for (T value : this.myLinkedList) {
            consumer.accept(value);
        }
    }

    public MyLinkedList list() {
        return this.myLinkedList;
    }
}
