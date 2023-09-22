
public class BSTNode<E extends Comparable<? super E>> {
    private E element;
    private BSTNode left; // Pointer to left child
    private BSTNode right; // Pointer to right child

    // Constructors
    BSTNode() {
        left = right = null;
    }


    BSTNode(E val) {
        left = right = null;
        element = val;
    }


    BSTNode(E val, BSTNode l, BSTNode r) {
        left = l;
        right = r;
        element = val;
    }


    // Get and set the element value
    public E value() {
        return element;
    }


    public void setValue(E v) {
        element = v;
    }


    public void setValue(Object v) { // We need this one to satisfy BinNode
                                     // interface
        if (!(v instanceof Comparable))
            throw new ClassCastException("A Comparable object is required.");
        element = (E)v;
    }


    // Get and set the left child
    public BSTNode left() {
        return left;
    }


    public void setLeft(BSTNode p) {
        left = p;
    }


    // Get and set the right child
    public BSTNode right() {
        return right;
    }


    public void setRight(BSTNode p) {
        right = p;
    }


    // return TRUE if a leaf node, FALSE otherwise
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }
}
