public class KVPair<K extends Comparable<K>, E>
    implements Comparable<KVPair<K, E>> {
    private K theKey; // The key
    private E theVal; // The value
    
//    public KVPair(K key, E val){
//        theKey = key;
//        theVal = val;
//    }
    public int compareTo(KVPair<K, E> it) {
        return theKey.compareTo(it.key());
    }


    public int compareTo(K it) {
        return theKey.compareTo(it);
    }


    public K key() {
        return theKey;
    }


    public E value() {
        return theVal;
    }
    
    public void setKey(K newKey) {
        theKey = newKey;
    }
    
    public void setVal(E newVal) {
        theVal = newVal;
    }


}
