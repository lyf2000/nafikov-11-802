//package CODEFORCES.task644C;

import java.io.*;

import java.util.*;


public class Main {


    static class Node<T> {

        private T value;
        private Node<T> next;


        public Node(T value) {
            this.value = value;
            next = null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    static class MyMap<K, S> {
        private K key;
        private int hash;
        private S set;

        public MyMap(K key, S set) {
            this.key = key;
            this.set = set;
            hash = key.hashCode();
        }

        public K getKey() {
            return key;
        }

        public S getSet() {
            return set;
        }

        public int getHash() {
            return hash;
        }


        @Override
        public boolean equals(Object o) {
            MyMap<?, ?> myMap = (MyMap<?, ?>) o;
            if (myMap != null) {
                return Objects.equals(key, myMap.key);
            }
            return false;
        }

    }

    static class MyLinkedList<T> implements Iterable<T> {

        private Node<T> head;
        private Node<T> last;
        private Node<T> node;
        private int size;

        public MyLinkedList() {
            size = 0;
        }

        public void remove(T current) {
            if (current == (head.getValue())) {
                head = head.getNext();
            } else if (current == (last.getValue())) {
                node = head;
                while (node.getNext() != last) {
                    node = node.getNext();
                }
                last = node;
            } else {
                node = head;
                while (node.getNext().getValue() != (current)) {
                    node = node.getNext();
                }
                node.setNext(node.getNext().getNext());
            }
            size--;
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
            private int mysize;

            public MyLinkedListIterator() {
                node = head;
                count = 0;
                mysize = size;
            }

            @Override
            public boolean hasNext() {
                return count < mysize;
            }

            @Override
            public T next() {
                count++;
                current = node;
                node = node.getNext();
                return current.getValue();
            }

        }


        public T getHeadValue() {
            return head.getValue();
        }

        public int getSize() {
            return this.size;
        }

        @Override
        public Iterator<T> iterator() {
            return new MyLinkedListIterator();
        }


    }

    static String s, s1, s2;

    //    static String start = "";
//    static MyLinkedList<MyMap<String, HashSet<String>>> myMapMyLinkedList;
//    static MyLinkedList<MyLinkedList<String>> res;
//
//    static ArrayList<MyMap<String, HashSet<String>>> arrayList;
//    static ArrayList<ArrayList<String>> list;
//
//
//    static void add() {
//        int hash = s1.hashCode();
//        for (MyMap<String, HashSet<String>> map : myMapMyLinkedList) {
//            if (map.getHash() == hash && map.getKey().equals(s1)) {
//                map.getSet().add(s2);
//                return;
//            }
//        }
//        HashSet<String> hs = new HashSet<>();
//        hs.add(s2);
//        MyMap<String, HashSet<String>> mm = new MyMap<>(s1, hs);
//        myMapMyLinkedList.add(mm);
//    }
//
//
//    static void add2() {
//        int hash = s1.hashCode();
//        for (MyMap<String, HashSet<String>> map : arrayList) {
//            if (map.getHash() == hash && map.getKey().equals(s1)) {
//                map.getSet().add(s2);
//                return;
//            }
//        }
//        HashSet<String> hs = new HashSet<>();
//        hs.add(s2);
//        MyMap<String, HashSet<String>> mm = new MyMap<>(s1, hs);
//        arrayList.add(mm);
//    }
//
//    static void select() {
//        for (MyMap<String, HashSet<String>> map : myMapMyLinkedList) {
//            if (map.key != null) {
//                MyLinkedList<String> a = new MyLinkedList<>();
//                for (MyMap<String, HashSet<String>> m : myMapMyLinkedList) {
//                    if (m.key != null) {
//                        if (map.set.equals(m.set)) {
//                            a.add(m.key);
//                            m.key = null;
//                        }
//                    }
//                }
//                if (a.getSize() >= 2) {
//                    res.add(a);
//                }
//            }
//        }
//    }
//
//    static void select2() {
//
//        for (MyMap<String, HashSet<String>> map : arrayList) {
//            if (map != null) {
//                ArrayList<String> a = new ArrayList<>();
//                for (MyMap<String, HashSet<String>> m : arrayList) {
//                    if (m != null) {
//                        if (map.set.equals(m.set)) {
//                            a.add(m.key);
//                            arrayList.set(arrayList.indexOf(m), null);
//                        }
//                    }
//                }
//                if (a.size() >= 2) {
//                    list.add(a);
//                }
//            }
//        }
//    }
//
//    static void clear() {
//        for (MyLinkedList m : res) {
//            if (m.getSize() < 2) {
//                res.remove(m);
//            }
//        }
//    }
//
//
////    static int count = 0;
//
//
//    static void show() {
////        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
////
////            bw.write(res.getSize() + "");
////            bw.newLine();
////            for (MyLinkedList<String> m : res) {
////                for (String s : m) {
////                    bw.write(s + " ");
////                }
////                bw.newLine();
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
//
//    static void show2() {
//        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
//
//            bw.write(list.size() + "");
//            bw.newLine();
//            for (ArrayList<String> m : list) {
//                for (String s : m) {
//                    bw.write(s + " ");
//                }
//                bw.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    static MyLinkedList<MyMap<String, HashSet<Integer>>> myLinkedList;
    static ArrayList<Integer> integers;
    static ArrayList<String> strings;
    static MyLinkedList<MyLinkedList<String>> res;

    static void add() {
        int hash1 = s1.hashCode();
        int hash2 = s2.hashCode();
        int index = integers.indexOf(hash2);
//        && strings.indexOf(s2) > -1
        if (!(index > -1 )) {
            index = strings.size();
            integers.add(hash2);
            strings.add(s2);
        }


        for (MyMap<String, HashSet<Integer>> map : myLinkedList) {
//            && map.getKey().equals(s1)
            if (map.getHash() == hash1 ) {
                map.getSet().add(index);
                return;
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        hs.add(index);
        MyMap<String, HashSet<Integer>> mm = new MyMap<>(s1, hs);
        myLinkedList.add(mm);
    }


    static void select() {
        for (MyMap<String, HashSet<Integer>> map : myLinkedList) {
            if (map.key != null) {
                MyLinkedList<String> a = new MyLinkedList<>();
                for (MyMap<String, HashSet<Integer>> m : myLinkedList) {
                    if (m.key != null) {
                        if (map.set.equals(m.set)) {
                            a.add(m.key);
                            m.key = null;
                        }
                    }
                }
                if (a.getSize() >= 2) {
                    res.add(a);
                }
            }
        }
    }

    static void show() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            bw.write(res.getSize() + "");
            bw.newLine();
            for (MyLinkedList<String> m : res) {
                for (String s : m) {
                    bw.write(s + " ");
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

//        myMapMyLinkedList = new MyLinkedList<>();

        int index;
        myLinkedList = new MyLinkedList<>();
        integers = new ArrayList<>();
        strings = new ArrayList<>();
        res = new MyLinkedList<>();
//        long bef = System.currentTimeMillis();
//        arrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                s = br.readLine();

                // TIME!!!

                index = s.indexOf('/', 7);
                index = index != -1 ? index : s.length();
                s1 = s.substring(0, index);
                s2 = s.substring(index);
                add();

//                add2();
//                add();

            }

//            long aft = System.currentTimeMillis();
//            if (aft - bef >= 4500) {
//                System.out.println("-1");
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        select();

        show();

//        res = new MyLinkedList<>();
//
////        list = new ArrayList<>();
//
//        select();
////        select2();
//
////        clear();
////        clear2();
//
//        show();
////        show2();

    }

}