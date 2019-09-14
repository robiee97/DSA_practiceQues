import java.util.*;

public class myhm<K, V> {
    class Pair {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Pair>[] buckets;
    int size = 0;

    public myhm() {
        buckets = new LinkedList[4];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    public boolean containsKey(K key) {
        int bi = hashFunction(key);
        int di = findWithinBucket(key, bi);

        if (di == -1) {
            return false;
        } else {
            return true;
        }

    }

    public void put(K key, V value) {
        int bi = hashFunction(key);
        int di = findWithinBucket(key, bi);

        if (di == -1) {
            Pair p2a = new Pair(key, value);
            buckets[bi].add(p2a);
            size++;
        } else {
            Pair p2u = buckets[bi].get(di);
            p2u.value = value;
        }

        double lambda = size * 1.0 / buckets.length;//---------(n/N)
        if (lambda > 2.0) {
            rehash();
        }
    }

    public V get(K key) {

        int bi = hashFunction(key);
        int di = findWithinBucket(key, bi);

        if (di == -1) {
            return null;
        } else {
            Pair p2u = buckets[bi].get(di);
            return p2u.value;
        }
    }

    public V remove(K key) {
        int bi = hashFunction(key);
        int di = findWithinBucket(key, bi);

        if (di == -1) {
            return null;
        } else {
            Pair p2r = buckets[bi].remove(di);
            size--;
            return p2r.value;
        }
    }

    public ArrayList<K> keySet(K key) {
        ArrayList<K> keys = new ArrayList<>();

        for (int di = 0; di < buckets.length; di++) {
            for (Pair p : buckets[di]) {
                keys.add(p.key);
            }
        }
        return keys;
    }

    private int hashFunction(K key) {
        int hc = key.hashCode(); // blackbox //hash
        int bi = Math.abs(hc) % buckets.length; //compression
        return bi;
    }

    private int findWithinBucket(K key, int bi) {
        int di = 0;
        for (Pair p : buckets[bi]) {
            if (p.key.equals(key)) {
                return di;
            }
            di++;
        }
        return -1;
    }

    private void rehash() {
        LinkedList<Pair>[] obuckets = buckets;
        buckets = new LinkedList[obuckets.length * 2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
        for (int bi = 0; bi < obuckets.length; bi++) {
            for (Pair p : buckets[bi]) {
                put(p.key, p.value);
            }
        }

    }

    public void display() {
        System.out.println("--------------------------");
        for (int di = 0; di < buckets.length; di++) {
            System.out.print("Bucket" + ":" + di);
            for (Pair p : buckets[di]) {
                System.out.print("[" + p.key + "," + p.value + "]");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }
}