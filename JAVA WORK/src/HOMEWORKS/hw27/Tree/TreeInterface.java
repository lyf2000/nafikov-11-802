package HOMEWORKS.hw27.Tree;

public interface TreeInterface<T extends Comparable<T>> {
    void insert(T value);

    void print();

    boolean remove(T value);

    boolean contains(T value);

    void printByLevels();

    boolean isBst();
}

