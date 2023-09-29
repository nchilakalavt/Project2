import student.TestCase;

public class BSTTest extends TestCase {
    private BST tree = new BST();
    private String[] keywords = { "Good", "Bad", "Ugly" };
    private Seminar sem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
        (short)15, (short)33, 10, keywords, "This is a great seminar");
    private Seminar sem2 = new Seminar(2, "Seminar Title", "2405231000", 75,
        (short)15, (short)33, 10, keywords, "This is a great seminar");
    private Seminar sem3 = new Seminar(3, "Seminar Title", "2405231000", 75,
        (short)15, (short)33, 10, keywords, "This is a great seminar");
    private Seminar sem10 = new Seminar(10, "Seminar Title", "2405231000", 75,
        (short)15, (short)33, 10, keywords, "This is a great seminar");
    private BSTNode<KVPair<Integer, Seminar>> root =
        new BSTNode<KVPair<Integer, Seminar>>();
       
    public void testExtra() {
    }
    public void testIsDuplicate() {
        tree.insert(10, sem1);
        tree.insert(10, sem2);
        tree.insert(10, sem3);
        tree.insert(10, sem10);
        assertEquals(tree.getNodeCount(), 4);
        root.setValue(new KVPair<Integer, Seminar>());
        root.value().setKey(10);
        root.value().setVal(sem1);
        
       // assertEquals(tree.isDuplicate(tree.getRoot()), 4);
    }
    public void testRemoveID() {
        tree.insert(10, sem1);
        //assertEquals(tree.remove(10, sem1), sem1);
        //assertEquals(tree.remove(30), null);
        tree.insert(15, sem2);
        tree.insert(13, sem3);
        tree.insert(19, sem10);
        //assertEquals(tree.remove(30), null);
        //assertFalse(tree.idInsert(15, sem1));
        
    }
   public void testTraverseTostring() {
       
   }
}