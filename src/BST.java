
// Binary Search Tree implementation
public class BST<K extends Comparable<K>, E> {
    private BSTNode<KVPair<K, E>> root;// Root of the BST
    private int nodeCount; // Number of nodes in the BST

    // constructor
    BST() {
        root = new BSTNode<KVPair<K, E>>();
        nodeCount = 0;
    }


    private BSTNode<KVPair<K, E>> findHelp(
        BSTNode<KVPair<K, E>> compareNode,
        K e) {
        if (compareNode == null || compareNode.value() == null) {
            return null;
        }
        if (compareNode.value().compareTo(e) == 0) {
            return compareNode;
        }
        else if (compareNode.value().compareTo(e) < 0) {
            findHelp(compareNode.left(), e);
        }

        else if (compareNode.value().compareTo(e) > 0) {
            findHelp(compareNode.right(), e);
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


    private void insertHelp(BSTNode<KVPair<K, E>> root, K e, E sem) {
        if (root == null) {
            root = new BSTNode<KVPair<K, E>>();
        }
        if (root.value() == null) {
            root.setValue(new KVPair<K, E>());
            root.value().setKey(e);
            root.value().setVal(sem);
        }
        else if (root.value().compareTo(e) == 0 || root.value().compareTo(
            e) > 0) {
            insertHelp(root.left(), e, sem);
        }
        else {
            insertHelp(root.right(), e, sem);
        }
    }


    // Reinitialize tree
    public void clear() {
        root = null;
        nodeCount = 0;
    }


    // Insert a record into the tree.
    // Records can be anything, but they must be Comparable
    // e: The record to insert.
    public void insert(K e, E sem) {
        insertHelp(root, e, sem);
        nodeCount++;
    }


    // Remove a record from the tree
    // key: The key value of record to remove
    // Returns the record removed, null if there is none.
    public BSTNode<KVPair<K, E>> remove(K key) {
        BSTNode<KVPair<K, E>> temp = findHelp(root, key); // First find it
        if (temp != null) {
            removeHelp(temp); // Now remove it
            nodeCount--;
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
        return nodeCount;
    }


    public void idInsert(K e, E sem) {
        if (find(e) != null) {
            System.out.println(
                "Error inserting. A record with this ID exists.");
        }
        insertHelp(root, e, sem);
        nodeCount++;
    }


    private BSTNode<KVPair<K, E>> findKeywordHelp(
        BSTNode<KVPair<K, E>> root,
        String key) {
        if (root == null) {
            return null;
        }
        else if (key.contains((String)root.value().value())) {
            findKeywordHelp(root.left(), key);
            findKeywordHelp(root.right(), key);
            return root;
        }
        else {
            findKeywordHelp(root.left(), key);
            findKeywordHelp(root.right(), key);
            return null;
        }
    }


    public BSTNode<KVPair<K, E>> findKeyword(String key) {
        return findKeywordHelp(root, key);
    }
    
    public int isDuplicate(BSTNode<KVPair<K, E>> isSameNode) {
        if (isSameNode.left() == null) {
            return 0;
        }
        BSTNode<KVPair<K, E>> leftNode = isSameNode.left();
        if (isSameNode.value().key() == leftNode.value().key()) {
            return 1 + isDuplicate(leftNode);
        }
        else {
            return 0;
        }
    }
}
