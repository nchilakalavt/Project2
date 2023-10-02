
import student.TestCase;

public class BSTTest extends TestCase {
    private BST tree = new BST();
    private BST bst = new BST();
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

    public void testInsert() {
        tree.insert(10, sem1);
        tree.insert(9, sem2);
        tree.insert(12, sem1);
        tree.insert(10, sem1);
        tree.insert(5, sem1);
        tree.insert(15, sem1);
       
        assertNotNull(tree.find(10));
    }

    public void testRemove() {
        assertFalse(tree.remove(10, sem1));
        tree.insert(10, sem1);
        assertTrue(tree.remove(10, sem1));
        assertFalse(tree.remove(30, sem1));
        tree.insert(15, sem1);
        tree.insert(13, sem1);
        tree.insert(30, sem1);
        tree.insert(8, sem1);
        assertTrue(tree.remove(15, sem1));
        assertTrue(tree.remove(8, sem1));
        tree.insert(10, sem1);
        tree.insert(5, sem1);
        tree.insert(8, sem1);
        assertTrue(tree.remove(10, sem1));
        assertTrue(tree.remove(8, sem1));
        bst.insert(15, sem1);

        assertFalse(bst.remove(10, sem1));

    }
    public void testFind() {
        systemOut().clearHistory();
        bst.find(10);
        String temp = systemOut().getHistory();
        String check = "Search FAILED -- There is no record with ID 10";
        bst.insert(10, sem1);
        bst.insert(10, sem1);
        bst.insert(5, sem1);
        bst.insert(15, sem1);

        bst.find(10);
    }
    
   public void testprint() {
       bst.print();
       bst.insert(10, sem1);
       bst.insert(5, sem1);
       bst.insert(15, sem2);
       bst.insert(2, sem3);
       bst.insert(7, sem3);
       
       systemOut().clearHistory();
       bst.print();
       String temp = systemOut().getHistory();
       String check = "null\r\n"
           + "15\r\n"
           + "null\r\n"
           + "10\r\n"
           + "null\r\n"
           + "7\r\n"
           + "null\r\n"
           + "5\r\n"
           + "null\r\n"
           + "2\r\n"
           + "null";
   }
   
   public void testPrintRange() {
       tree.insert(10, sem1);
       tree.insert(9, sem1);
       tree.insert(10, sem1);
       tree.insert(10, sem2);
       tree.insert(5, sem3);
       tree.insert(3, sem3);
       tree.insert(18, sem1);
       tree.insert(15, sem2);
       
       systemOut().clearHistory();
       tree.printRange(5, 15);
       String temp = systemOut().getHistory();
       String check = "ID: 3, Title: Seminar Title\r\n"
           + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 10\r\n"
           + "Description: This is a great seminar\r\n"
           + "Keywords: Good, Bad, Ugly\r\n"
           + "ID: 1, Title: Seminar Title\r\n"
           + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 10\r\n"
           + "Description: This is a great seminar\r\n"
           + "Keywords: Good, Bad, Ugly\r\n"
           + "ID: 2, Title: Seminar Title\r\n"
           + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 10\r\n"
           + "Description: This is a great seminar\r\n"
           + "Keywords: Good, Bad, Ugly\r\n"
           + "ID: 1, Title: Seminar Title\r\n"
           + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 10\r\n"
           + "Description: This is a great seminar\r\n"
           + "Keywords: Good, Bad, Ugly\r\n"
           + "ID: 1, Title: Seminar Title\r\n"
           + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 10\r\n"
           + "Description: This is a great seminar\r\n"
           + "Keywords: Good, Bad, Ugly\r\n"
           + "ID: 2, Title: Seminar Title\r\n"
           + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 10\r\n"
           + "Description: This is a great seminar\r\n"
           + "Keywords: Good, Bad, Ugly\r\n";
       assertEquals(temp, check);
   }
   
   
   public void testGetNode() {
       assertEquals(bst.getNodeCount(), 0);
   }
   
}