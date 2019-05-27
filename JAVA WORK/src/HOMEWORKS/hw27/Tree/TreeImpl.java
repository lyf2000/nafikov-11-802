package HOMEWORKS.hw27.Tree;

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
    public boolean remove(T value) {
        Node current = contains(root, value);
        if (current == null) {
            System.out.println("There is no value " + value);
            return false;
        }
        remove(current);
        return true;
    }

    private void remove(Node root) {
        if (root.right != null) {
            Node prev = getPrevious(this.root, root);
            Node left = root.left;
            prev.right = root.right;
            if (prev.right.left != null) {
                getMin(prev.right.left).left = left;
            } else {
                prev.right.left = left;
            }
        } else { //OK
            Node prev = getPrevious(this.root, root);
            prev.left = root.left;
        }
    }

    private Node getPrevious(Node current, Node root) {
        int i = ((T) root.value).compareTo((T) current.value);
        if (i > 0) {
            if (current.right == root) {
                return current;
            }
            return getPrevious(current.right, root);
        } else if (i < 0) {
            if (current.left == root) {
                return current;
            }
            return getPrevious(current.left, root);
        } else {
            return current;
        }
    }

    private Node getMin(Node root) {
        if (root.left == null) {
            return root;
        }
        return root.left;
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


    @Override
    public void printByLevels() {
        System.out.println();
    }

    public void printByLevels(Node root) {

    }

    @Override
    public boolean isBst() {
        return false;
    }

    public int getHeight(Node root, int count) {
        if (root == null) {
            return count;
        }
        return Math.max(this.getHeight(root.left, count + 1),
                this.getHeight(root.right, count + 1));
    }
}

