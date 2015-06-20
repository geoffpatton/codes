

/**
 * Created by tua26762 on 6/20/2015.
 */
public class OrderedPair<K, V> {
//    public class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }
}