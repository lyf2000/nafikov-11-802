package hw24;

public interface Map<K, V> {
    void put(K key, V value);
    V get(K key);
}