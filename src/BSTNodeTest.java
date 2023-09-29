import student.TestCase;
public class BSTNodeTest extends TestCase{
    BSTNode<Integer> radio;
    BSTNode<Integer> radio2;
    BSTNode<Integer> radioFinal;

    public void setUp() {
        // BSTNode<Integer> tester = new BSTNode<Integer>();
        int x = 5;
        radio = new BSTNode<Integer>(3);
        radio2 = new BSTNode<Integer>();
        radioFinal = new BSTNode<Integer>(x, radio, radio2);
        // radioFinal.setLeft();

    }

    public void testDuplicate() {
        int a = 1;
        assertEquals(a, radio.duplicateCount());
        radio.incrementDuplicateCount();
        a ++;
        assertEquals(a, radio.duplicateCount());
        radio2.setLevel(2);
        assertEquals(radio2.getLevel(), 2);
    }
    public void testConstructor() {
        assertNotNull(radio);
       
       assertEquals(radioFinal.left(), radio);
       assertEquals(radioFinal.right(), radio2);

       Integer three = 3;
    }
    public void testValue() {
        assertEquals(radio.value().intValue(), 3);
        radio2.setValue(3);
        assertEquals(radio2.value().intValue(), 3);
        BSTNode<Integer> replaceLeft = new BSTNode<Integer>(9);
        BSTNode<Integer> replaceRight = new BSTNode<Integer>(7);
        radioFinal.setLeft(replaceLeft);
        assertEquals(radioFinal.left(), replaceLeft);
        assertEquals(radioFinal.right(), radio2);
        assertTrue(replaceRight.isLeaf());
        radioFinal.setRight(replaceRight);
        assertFalse(radioFinal.isLeaf());
        assertEquals(radioFinal.right(), replaceRight);
        replaceLeft.setRight(radio2);
        assertFalse(replaceLeft.isLeaf());
    }

}
