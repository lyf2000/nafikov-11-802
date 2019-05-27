package HOMEWORKS_2SEM.Dhw24.my_linked_list;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> last;
    private Node<T> node;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);
            last = head;
            size++;
            return;
        }
        node = new Node<>(value);
        last.setNext(node);
        last = node;
        size++;
    }

    private class MyLinkedListIterator implements Iterator<T> {

        private Node<T> node;
        private Node<T> current;
        private int count;

        public MyLinkedListIterator() {
            node = head;
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            count++;
            current = node;
            node = node.getNext();
            return current.getValue();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }
}
