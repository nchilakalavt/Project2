
public class BSTNode<E extends Comparable<? super E>> {
    private E element;
    private BSTNode<E> left; // Pointer to left child
    private BSTNode<E> right; // Pointer to right child
    private int level;

    // Constructors
    BSTNode() {
        left = right = null;
        level = 0;
    }


    BSTNode(E val) {
        left = right = null;
        element = val;
        level = 0;
    }


    BSTNode(E val, BSTNode<E> l, BSTNode<E> r) {
        left = l;
        right = r;
        element = val;
        level = 0;
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
    public BSTNode<E> left() {
        return left;
    }
    

    public void setLeft(BSTNode<E> p) {
        left = p;
    }


    // Get and set the right child
    public BSTNode<E> right() {
        return right;
    }


    public void setRight(BSTNode<E> p) {
        right = p;
    }


    // return TRUE if a leaf node, FALSE otherwise
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }
    
    public int getLevel() {
        return level;
    }
    public void setLevel(int levelNum) {
        level = levelNum;
    }
}
