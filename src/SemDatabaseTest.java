import student.TestCase;

public class SemDatabaseTest extends TestCase {
    private String[] keywords = { "Good", "Bad", "Ugly" };
    private Seminar mysem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
        (short)15, (short)33, 10, keywords, "This is a great seminar");
    private Seminar mysem2 = new Seminar(2, "Seminar Title", "2405231000", 75,
        (short)15, (short)33, 12, keywords, "This is a great seminar");
    private Seminar mysem3 = new Seminar(3, "Seminar Title", "2405231000", 75,
        (short)15, (short)33, 15, keywords, "This is a great seminar");
    private Seminar mysem10 = new Seminar(10, "Seminar Title", "2405231000", 75,
        (short)15, (short)33, 10, keywords, "This is a great seminar");
    SemDatabase semD = new SemDatabase(128);

    public void testInsert() {
        semD.insert(mysem1);
        Seminar mysemDupID = new Seminar(1, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        semD.insert(mysemDupID);
    }


    public void testSearchID() {
        semD.insert(mysem1);
        assertEquals(semD.searchID(1), mysem1);
        assertEquals(semD.searchID(2), null);
    }


    public void testSearchCost() {
        semD.insert(mysem1);
        semD.insert(mysem2);
        semD.insert(mysem3);
        semD.insert(mysem10);
        Seminar[] semArr = { mysem1, mysem2, mysem3, mysem10 };
        System.out.println();
        System.out.println(semD.searchCost(10, 15));
    }
    
    public void testIsDuplicate() {
        semD.insert(mysem1);
        semD.insert(mysem2);
        semD.insert(mysem3);
        semD.insert(mysem10);
        
    }

}
