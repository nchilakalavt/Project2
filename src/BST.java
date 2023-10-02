// Binary Search Tree implementation
public class BST<K extends Comparable<K>, E> {
    private BSTNode<KVPair<K, E>> root; // Root of the BST
    private int nodecount; // Number of nodes in the BST

    // constructor
    BST() {
        root = null;
        nodecount = 0;
    }


    // Reinitialize tree
    public void clear() {
        root = null;
        nodecount = 0;
    }

    public boolean idInsert(K e, E sem) {
        if (find(e) != null) {
            return false;
        }
        else {
            root = insertHelp(root, new KVPair<K, E>(e, sem));
            nodecount++;
            return true;
        }
    }
    // Insert a record into the tree.
    // Records can be anything, but they must be Comparable
    // e: The record to insert.
    public void insert(K e, E sem) {
        root = insertHelp(root, new KVPair<K, E>(e, sem));
        nodecount++;
    }


    // Remove a record from the tree
    // key: The key value of record to remove
    // Returns the record removed, null if there is none.
    public boolean remove(K key, E sem) {
        BSTNode<KVPair<K, E>> temp = findHelp(root, key); // First find it
        if (temp != null) {
            root = removeHelp(root, key, new KVPair<K, E>(key, sem)); // Now remove it
            nodecount--;
            return true;
        }
        return false;
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


    private BSTNode<KVPair<K, E>> findHelp(BSTNode<KVPair<K, E>> rt, K key) {
        if (rt == null) {
            return null;
        }
        if (rt.value().compareTo(key) > 0) {
            return findHelp(rt.left(), key);
        }
        else if (rt.value().compareTo(key) == 0) {
            return rt;
        }
        else {
            return findHelp(rt.right(), key);
        }
    }


    private BSTNode<KVPair<K, E>> insertHelp(
        BSTNode<KVPair<K, E>> rt,
        KVPair<K, E> node) {
        if (rt == null) {
            return new BSTNode<KVPair<K, E>>(node);
        }
        if (rt.value().compareTo(node) >= 0) {
            rt.setLeft(insertHelp(rt.left(), node));
        }
        else {
            rt.setRight(insertHelp(rt.right(), node));
        }
        return rt;
    }


    private BSTNode<KVPair<K, E>> removeHelp(
        BSTNode<KVPair<K, E>> rt,
        K key,
        KVPair<K, E> node) {
//        if (rt == null) {
//            return null;
//        }
        if (rt.value().compareTo(key) > 0) {
            rt.setLeft(removeHelp(rt.left(), key, node));
        }
        else if (rt.value().compareTo(key) < 0) {
            rt.setRight(removeHelp(rt.right(), key, node));
        }
        else {
            if (rt.value() == node.value()) {
                root.setLeft(removeHelp(root.left(), key, node));
            }
            else if (root.left() == null) {
                return root.right();
            }
            else if (root.right() == null) {
                return root.left();
            }
            else {
                root.setValue(getMax(root.left()).value());
                root.setLeft(deleteMax(root.left()));
            }
        }
        return rt;
    }


    private BSTNode<KVPair<K, E>> getMax(BSTNode<KVPair<K, E>> rt) {
        if (rt.right() == null) {
            return rt;
        }
        
        return getMax(rt.right());
    }


    private BSTNode<KVPair<K, E>> deleteMax(BSTNode<KVPair<K, E>> rt) {
        if (rt.right() == null) {
            return rt.left();
        }
        rt.setRight(deleteMax(rt.right()));
        return rt;
    }


    public BSTNode<KVPair<K, E>> getRoot() {
        return root;
    }


    private void printHelp(BSTNode<KVPair<K, E>> rt) {
        if (rt == null) {
            System.out.println("null");
        }
        else {
            printHelp(rt.left());
            System.out.println(root.value().key());
            printHelp(rt.right());
        }
    }


    public void print() {
        printHelp(root);

    }


    public int getNodeCount() {
        return nodecount;
    }

    public void printRange(K low, K high) {
        printRangeHelp(root, low, high, 0);
    }
    
    private void printRangeHelp(
        BSTNode<KVPair<K, E>> root,
        K low,
        K high,
        int count) {
        if (root != null) {

            printRangeHelp(root.left(), low, high, count++);
            if (low.compareTo(root.value().key()) <= 0 && high.compareTo(root
                .value().key()) >= 0) {
                System.out.println(root.value().value().toString());
                count++;
            }
            printRangeHelp(root.right(), low, high, count++);
        }
    }
}
