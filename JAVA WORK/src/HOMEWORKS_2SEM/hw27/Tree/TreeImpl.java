package HOMEWORKS_2SEM.hw27.Tree;

public class TreeImpl<T extends Comparable<T>> implements TreeInterface<T> {

    private static class Node<T> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        Node(T value) {
            this.value = value;
            right = left = null;
        }
    }

    public TreeImpl() {
        root = null;
    }

    private Node<T> root;

    //+++
    @Override
    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node root, T value) {
        if (root == null) {
            root = new Node(value);
        } else {
            if (value.compareTo((T) root.value) > 0) {
                root.right = insert(root.right, value);
            } else {
                root.left = insert(root.left, value);
            }
        }
        return root;
    }


    //+++
    @Override
    public void print() {
        print(root);
        System.out.println();
    }

    private void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.value + " ");
            print(root.right);
        }
    }


    //+++
    @Override
    public boolean contains(T value) {
        return contains(root, value) != null;
    }
    private Node contains(Node root, T value) {


        if (root == null) {
            return null;
        }
        int i = value.compareTo((T) root.value);

        if (i == 0) {
            return root;
        }
        if (i > 0) {
            return contains(root.right, value);
        }
        return contains(root.left, value);
    }


    //+++
    @Override
    public boolean remove(T value) {
        if (!this.contains(value)) return false;
        root = remove(root, value);
        return true;
    }
    private Node<T> remove(Node<T> root, T value) {
        if (root == null) return root;

        if (value.compareTo(root.value) < 0)
            root.left = remove(root.left, value);
        else if (value.compareTo(root.value) > 0)
            root.right = remove(root.right, value);

        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.value = (T) getMin(root.right).value;

            root.right = remove(root.right, root.value);
        }

        return root;
    }


    @Override
    public void printByLevels() {

    }


    @Override
    public boolean isBst() {
        return false;
    }


    private Node getMin(Node root) {
        if (root.left == null) {
            return root;
        }
        return root.left;
    }


}

