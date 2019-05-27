package HOMEWORKS_2SEM.hw27.Tree;

public interface TreeInterface<T extends Comparable<T>> {
    void insert(T value);
    void print();
    boolean contains(T value);
    boolean remove(T value);

    void printByLevels();

    boolean isBst();
}

