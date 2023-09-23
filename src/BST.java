
// Binary Search Tree implementation
public class BST<K extends Comparable<K>, E> {
    private BSTNode<KVPair<K, E>> root;// Root of the BST
    private int nodecount; // Number of nodes in the BST

    // constructor
    BST() {
        root = null;
        nodecount = 0;
    }


    private BSTNode<KVPair<K, E>> findHelp(
        BSTNode<KVPair<K, E>> removeNode,
        K e) {
        if (root == null) {
            return null;
        }
        if (e.compareTo(root.value().key()) == 0) {
            return root;
        }
        else if (e.compareTo(root.value().key()) < 0) {
            findHelp(root.left(), e);
        }

        else if (e.compareTo(root.value().key()) > 0) {
            findHelp(root.right(), e);
        }
        return null;
    }


    private void removeHelp(BSTNode<KVPair<K, E>> root) {
        if (root.isLeaf()) {
            BSTNode<KVPair<K, E>> temp = root;
            root = null;
        }
        else {
            root.setValue(null);
            reorder(root);
        }
    }


    private void reorder(BSTNode<KVPair<K, E>> removeNode) {
        if (removeNode.isLeaf()) {
            removeNode = null;
        }
        else if (removeNode.left() == null) {
            removeNode.setValue(removeNode.right().value());
            removeNode.right().setValue(null);
            reorder(removeNode.right());
        }
        else {
            removeNode.setValue(removeNode.left().value());
            removeNode.left().setValue(null);
            reorder(removeNode.left());
        }
    }


    private void insertHelp(BSTNode<KVPair<K, E>> root, K e) {
        if (root == null) {
            root.setValue(e);
        }
        else if (e.compareTo(root.value().key()) == 0 || e.compareTo(root
            .value().key()) < 0) {
            insertHelp(root.left(), e);
        }
        else {
            insertHelp(root.right(), e);
        }
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
        insertHelp(root, e);
        nodecount++;
    }


    // Remove a record from the tree
    // key: The key value of record to remove
    // Returns the record removed, null if there is none.
    public BSTNode<KVPair<K, E>> remove(K key) {
        BSTNode<KVPair<K, E>> temp = findHelp(root, key); // First find it
        if (temp != null) {
            removeHelp(temp); // Now remove it
            nodecount--;
        }
        return temp;
    }


    // Return the record with key value k, null if none exists
    // key: The key value to find
    public BSTNode<KVPair<K, E>> find(K key) {
        return findHelp(root, key);
    }


    // Return the number of records in the dictionary
    public int size() {
        return nodecount;
    }
}
