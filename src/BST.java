
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
        else if (removeNode.right() == null) {
            removeNode.setValue(removeNode.left().value());
            removeNode.left().setValue(null);
            reorder(removeNode.left());
        }
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


    // Remove a record from the tree
    // key: The key value of record to remove
    // Returns the record removed, null if there is none.
    public E removeID(K key) {
        if (nodeCount == 0) {
            System.out.println("Tree is Empty");
            return null;
        }
        BSTNode<KVPair<K, E>> removeNode = findHelp(root, key);// First find it

        if (removeNode != null) {
            E retVal = removeNode.value().value();
            removeHelp(removeNode); // Now remove it
            nodeCount--;
            System.out.println("Record with ID " + key
                + " successfully deleted from the database");
            return retVal;
        }
        else {
            System.out.println("Delete FAILED -- There is no record with ID "
                + key);
            return null;
        }
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
            System.out.println("Found record with ID " + root.value().key());
            System.out.println(root.value().value().toString());
        }
    }


    public boolean idInsert(K e, E sem) {
        if (findHelp(root, e) != null) {
            System.out.println(
                "Error inserting. A record with this ID exists.");
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


    public void printRange(BSTNode<KVPair<K, E>> root, K low, K high) {

        if (root == null) {
            return;
        }
        printRange(root.left(), low, high);
        if (low.compareTo(root.value().key()) <= 0 && high.compareTo(root
            .value().key()) >= 0) {
            System.out.println(root.value().value().toString());
        }
        printRange(root.right(), low, high);
    }


    public void removeNotID(BSTNode<KVPair<K, E>> compareNode, E val) {
        if (compareNode == null || compareNode.value() == null) {
            return;
        }
        else if (compareNode.value().value() == val) {
            nodeCount--;
            if (root.isLeaf()) {
                BSTNode<KVPair<K, E>> temp = root;
                root = null;
            }
            else {

                root.setValue(null);
                reorder(root);
            }
        }
        removeNotID(compareNode.left(), val);
        removeNotID(compareNode.right(), val);
    }

}
