
// Binary Search Tree implementation
public class BST<K extends Comparable<K>, E> {
    private BSTNode<KVPair<K, E>> root;// Root of the BST
    private int nodecount; // Number of nodes in the BST
    
    
    
    // constructor
    BST() {
        root = null;
        nodecount = 0;
    }
    
    
    private Comparable findHelp(BSTNode<KVPair<K, E>> root, K e) {
        if (root == null) {
            return null;
        }
        if (e.compareTo(root.value().key()) == 0) {
            return root.value();
        }
        else if (e.compareTo(root.value().key()) < 0) {
            findHelp(root.left(), e);
        }
        
        else if (e.compareTo(root.value().key()) > 0) {
            findHelp(root.right(), e);
        }
        return null;
    }
    
    private BSTNode<KVPair<K, E>> removeHelp(
        BSTNode<KVPair<K, E>> root,
        K e) {
        
        return null;
    }
    
    private BSTNode<KVPair<K, E>> insertHelp(
        BSTNode<KVPair<K, E>> root,
        K e) {
        return null;
    }

    // Reinitialize tree
    public void clear() {
        root = null;
        nodecount = 0;
    }


    // Insert a record into the tree.
    // Records can be anything, but they must be Comparable
    // e: The record to insert.
    public void insert(K e) {
        root = insertHelp(root, e);
        nodecount++;
    }





    // Remove a record from the tree
    // key: The key value of record to remove
    // Returns the record removed, null if there is none.
    public Comparable remove(K key) {
        Comparable temp = findHelp(root, key); // First find it
        if (temp != null) {
            root = removeHelp(root, key); // Now remove it
            nodecount--;
        }
        return temp;
    }




    // Return the record with key value k, null if none exists
    // key: The key value to find
    public Comparable find(K key) {
        return findHelp(root, key);
    }


    // Return the number of records in the dictionary
    public int size() {
        return nodecount;
    }
}
