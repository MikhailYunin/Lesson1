package lesson8;

public class Pair <K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(34,"String");
    }
}
