
// Binary Search Tree implementation
public class BST<K extends Comparable<K>, E> {
    private BSTNode<KVPair<K, E>> root;// Root of the BST
    private int nodeCount; // Number of nodes in the BST

    // constructor
    BST() {
        root = new BSTNode<KVPair<K, E>>();
        nodeCount = 0;
    }


    public BSTNode<KVPair<K, E>> getRoot() {
        return root;
    }


    public BSTNode<KVPair<K, E>> findHelp(
        BSTNode<KVPair<K, E>> compareNode,
        K e) {
        BSTNode<KVPair<K, E>> retNode = null;
        if (compareNode == null || compareNode.value() == null) {
            return null;
        }
        else if (compareNode.value().compareTo(e) == 0) {
            return compareNode;
        }
        else if (compareNode.value().compareTo(e) > 0) {
            return (findHelp(compareNode.left(), e));
        }

        else {
            return (findHelp(compareNode.right(), e));
        }

    }

    public void remove(K key, E val) {
        BSTNode<KVPair<K, E>> temp = findHelp(root, key); // First find it
        if (temp != null) {
          root = removeHelp(root, key, val); // Now remove it
          nodeCount--;
        }
      }
    
    private BSTNode<KVPair<K, E>> removeHelp(
        BSTNode<KVPair<K, E>> root,
        K key, E value) {
        if (root == null) {
            return null;
        }
        if (root.value().compareTo(key) > 0) {
            root.setLeft(removeHelp(root.left(), key, value));
        }
        else if (root.value().compareTo(key) < 0) {
            root.setRight(removeHelp(root.left(), key, value));
        }
        else {
            if (root.value().value() != value) {
                root.setLeft(removeHelp(root.left(), key, value));
            }
            else if (root.isLeaf()) {
                
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
        return root;
    }


    private BSTNode<KVPair<K, E>> getMax(BSTNode rt) {
        if (rt.right() == null)
            return rt;
        return getMax(rt.right());
    }


    private BSTNode<KVPair<K, E>> deleteMax(BSTNode<KVPair<K, E>> rt) {
        if (rt.right() == null) {
            return rt.left();
        }
        rt.setRight(deleteMax(rt.right()));
        return rt;
    }


    private void insertHelp(BSTNode<KVPair<K, E>> root, K e, E sem) {
        BSTNode<KVPair<K, E>> rootLeftRight = new BSTNode<KVPair<K, E>>();

        if (root.value() == null) {
            root.setValue(new KVPair<K, E>());
            root.value().setKey(e);
            root.value().setVal(sem);
            root.setLevel(root.getLevel() + 1);
        }

        else if (root.value().compareTo(e) == 0 || root.value().compareTo(
            e) > 0) {
            if (root.left() == null) {
                root.setLeft(rootLeftRight);
                insertHelp(rootLeftRight, e, sem);
            }
            else {
                insertHelp(root.left(), e, sem);
            }
        }
        else {
            if (root.right() == null) {
                root.setRight(rootLeftRight);
                insertHelp(rootLeftRight, e, sem);
            }
            else {
                insertHelp(root.right(), e, sem);
            }

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


    // Return the record with key value k, null if none exists
    // key: The key value to find
    public void find(K key) {
        if (nodeCount == 0) {
            System.out.println("Search FAILED -- There is no record with ID "
                + key);
            return;
        }
        BSTNode<KVPair<K, E>> findNode = findHelp(root, key);
        if (findNode == null) {
            System.out.println("There is no record with ID " + root.value()
                .key());
        }
        else {
            System.out.println("Found record with ID " + key + ":");
            System.out.println(root.value().value().toString());
        }
    }


    public boolean idInsert(K e, E sem) {
        if (findHelp(root, e) != null) {
            System.out.println(
                "Insert FAILED - There is already a record with ID " + e);
            return false;
        }
        else {
            insertHelp(root, e, sem);
            nodeCount++;
            return true;
        }
    }


    public int getNodeCount() {
        return nodeCount;
    }


    public void traverseToString(BSTNode<KVPair<K, E>> root) {

        if (root == null || root.value() == null) {
            System.out.println("null");
        }
        else {
            traverseToString(root.right());
            System.out.println(root.value().key());
            traverseToString(root.left());
        }

    }


    public void printRange(
        BSTNode<KVPair<K, E>> root,
        K low,
        K high,
        int count) {
        if (root != null) {

            printRange(root.left(), low, high, count++);
            if (low.compareTo(root.value().key()) <= 0 && high.compareTo(root
                .value().key()) >= 0) {
                System.out.println(root.value().value().toString());
                count++;
            }
            printRange(root.right(), low, high, count++);
        }
    }


    public void printRangeCount(K low, K high) {
        int count = 0;
        printRange(root, low, high, 0);
    }

}
