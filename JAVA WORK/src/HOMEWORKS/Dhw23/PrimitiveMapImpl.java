package HOMEWORKS.Dhw23;


public class PrimitiveMapImpl<K extends Comparable<K>, V> implements Map<K, V> {

    final static private int SIZE = 16;
    private static Node last[];
    private Node<K, V> nodes[];
    private Node<K, V> node;

    private static class Node<K, V> {

        private K key;
        private V value;
        private int hash;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = key.hashCode();
        }

        public Node<K, V> getNext() {
            return next;
        }

        public V getValue() {
            return value;
        }

        public int getHash() {
            return hash;
        }

        public K getKey() {
            return key;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        public void setValue(V value) {
            this.value = value;
        }

        boolean hasNext() {
            return next != null;
        }
    }

    public PrimitiveMapImpl() {
        this.nodes = new Node[SIZE];
        last = new Node[SIZE];
    }

    @Override
    public void put(K key, V value) {
        int hash = key.hashCode() & (nodes.length - 1);
        if (nodes[hash] == null) {
            nodes[hash] = new Node<>(key, value);
            last[hash] = nodes[hash];
            return;
        }

        node = getNode(key.hashCode(), nodes[hash]);

        if (node != null) {
            if (key.compareTo(node.getKey()) != 0) {
                node.setValue(value);
                return;
            }
        } else if (last[hash].getHash() == key.hashCode()) {
            if (last[hash].getKey() == key) {
                last[hash].setValue(value);
                return;
            } else {
            }
        }

        node = new Node<>(key, value);
        last[hash].next = node;
        last[hash] = node;
    }

    private Node getNode(int hash, Node head) {
        while (head.hasNext()) {
            if (head.getHash() == hash) {
                return head;
            }
            head = head.getNext();
        }
        return null;
    }

    @Override
    public V get(K key) {
        int hash = (nodes.length - 1) & key.hashCode();

        if (nodes[hash] == null) {
            return null;
        }

        node = getNode(key.hashCode(), nodes[hash]);
        if (node != null) {
            return node.getValue();
        }
        return null;
    }

    void show() {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) {
                node = nodes[i];
                while (node.hasNext()) {
                    System.out.print((String)node.getKey() + node.getValue() + " | ");
                    node = node.next;
                }
                System.out.println((String)last[i].key + last[i].getValue());
                System.out.println();
            }
        }
    }
}
