import student.TestCase;

public class SemDatabaseTest extends TestCase {
    private String[] keywords = { "HCI", "Computer_Science", "VT",
    "Virginia_Tech" };
    private String[] keywords2 = {"Bioinformatics", "computation_biology",
        "Biology", "Computer_Science", "VT", "Virginia_Tech"};
    private String[] keywords3 = { "HPC", "CSE", "computer_science" };
    private String[] keywords10 = { "high_performance_computing", "grids", "VT",
        "computer", "science" };
    private Seminar mysem1 = new Seminar(1, "Seminar Title", "2405231000", 75,
        (short)15, (short)33, 10, keywords, "This is a great seminar");
    private Seminar mysem2 = new Seminar(2, "Seminar Title", "2405231000", 75,
        (short)15, (short)33, 12, keywords, "This is a great seminar");
    private Seminar mysem3 = new Seminar(3, "Seminar Title", "2405231000", 75,
        (short)15, (short)33, 15, keywords, "This is a great seminar");
    private Seminar mysem10 = new Seminar(10, "Seminar Title", "2405231000", 75,
        (short)15, (short)33, 10, keywords, "This is a great seminar");
    private SemDatabase semD = new SemDatabase(128);

    
    public void testInsert() {
        semD.insert(mysem1);
        Seminar mysemDupID = new Seminar(1, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        semD.insert(mysemDupID);
        System.out.println();
    }


    public void testSearchID() {
        semD.insert(mysem1);
        systemOut().clearHistory();
        semD.searchID(1);
        String temp = systemOut().getHistory();
        String check = "Found record with ID 1:\r\n"
            + "ID: 1, Title: Seminar Title\r\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 10\r\n"
            + "Description: This is a great seminar\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n";
        assertEquals(temp, check);
        System.out.println();
        systemOut().clearHistory();
        semD.searchID(2);
        String temp2 = systemOut().getHistory();
        String check2 = "There is no record with ID 1\n";
        assertEquals(temp2, check2);
    }


    public void testSearchCost() {
        semD.insert(mysem1);
        semD.insert(mysem2);
        semD.insert(mysem3);
        semD.insert(mysem10);
        Seminar mysem11 = new Seminar(10, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 9, keywords, "This is a great seminar");
        Seminar mysem12 = new Seminar(10, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 16, keywords, "This is a great seminar");
        semD.insert(mysem11);
        semD.insert(mysem12);
        Seminar[] semArr = { mysem1, mysem2, mysem3, mysem10 };
        systemOut().clearHistory();
        semD.searchCost(10, 15);
        String temp = systemOut().getHistory();
        String check = "Seminars with costs in range 10 to 15:\r\nID: 10, Title: Seminar Title\r\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 10\r\n"
            + "Description: This is a great seminar\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 1, Title: Seminar Title\r\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 10\r\n"
            + "Description: This is a great seminar\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 2, Title: Seminar Title\r\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 12\r\n"
            + "Description: This is a great seminar\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 3, Title: Seminar Title\r\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 15\r\n"
            + "Description: This is a great seminar\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n";
        assertEquals(temp, check);
    }


    public void testSearchKeyword() {
        semD.insert(mysem1);
        semD.insert(mysem2);
        semD.insert(mysem3);
        semD.insert(mysem10);
        System.out.println("\n");
        systemOut().clearHistory();
        semD.searchKeyword("VT");
        String temp = systemOut().getHistory();
        String check = "Seminars matching keyword VT:\r\nID: 10, Title: Seminar Title\r\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 10\r\n"
            + "Description: This is a great seminar\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 3, Title: Seminar Title\r\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 15\r\n"
            + "Description: This is a great seminar\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 2, Title: Seminar Title\r\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 12\r\n"
            + "Description: This is a great seminar\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 1, Title: Seminar Title\r\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 10\r\n"
            + "Description: This is a great seminar\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n";
        assertEquals(temp, check);

    }


    public void testSearchDate() {
        semD.insert(mysem1);
        semD.insert(mysem2);
        semD.insert(mysem3);
        semD.insert(mysem10);
        System.out.println("\n");
        systemOut().clearHistory();
        semD.searchDate("0", "2405231000");
        String temp = systemOut().getHistory();
        String check = "Seminars with dates in range 0 to 2405231000:\r\nID: 10, Title: Seminar Title\r\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 10\r\n"
            + "Description: This is a great seminar\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 3, Title: Seminar Title\r\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 15\r\n"
            + "Description: This is a great seminar\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 2, Title: Seminar Title\r\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 12\r\n"
            + "Description: This is a great seminar\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 1, Title: Seminar Title\r\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 10\r\n"
            + "Description: This is a great seminar\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n";
        assertEquals(temp, check);
    }


    public void testPrintDate() {
        semD.insert(mysem1);
        semD.insert(mysem2);
        semD.insert(mysem3);
        semD.insert(mysem10);
        semD.printDate();
    }


    public void testDelete() {
        semD.delete(1);
        semD.insert(mysem1);
        semD.delete(1);
        semD.insert(mysem1);
        semD.insert(mysem2);
        semD.insert(mysem3);
        semD.insert(mysem10);
        semD.delete(1);
        semD.delete(3);
        semD.delete(10);
    }


    public void testAll() {
        semD.printID();
        semD.searchID(1);
        semD.searchKeyword("VT");

        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)-1, (short)10, 45, keywords,
            "This seminar will present an overview of HCI research at VT");
        semD.insert(sem1);
        
        Seminar sem11 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)128, 45, keywords,
            "This seminar will present an overview of HCI research at VT");
        semD.insert(sem11);
        
        Seminar sem111 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, keywords,
            "This seminar will present an overview of HCI research at VT");
        semD.insert(sem111);
        
        Seminar sem2 = new Seminar(2,
            "Computational Biology and Bioinformatics in CS at Virginia Tech",
            "0610071600", 60, (short)10, (short)10, 30, keywords2,
            "Introduction to bioinformatics and computation biology");
        semD.insert(sem2);
        
        Seminar sem10 = new Seminar(10, "Computing Systems Research at VT",
            "0701250830", 30, (short)30, (short)10, 17, keywords10,
            "Seminar about the Computing systems research at VT");
        semD.insert(sem10);
        
        Seminar sem3 = new Seminar(3, "Overview of HPC and CSE Research at VT",
            "1203301125", 35, (short)0, (short)0, 25, keywords3,
            "Learn what kind of research is done on HPC and CSE at VT");
        semD.insert(sem3);
        
        semD.printID();
        semD.printDate();
        semD.printKeyword();
        semD.printCost();
        semD.insert(sem10);
        semD.searchKeyword("VT");
        semD.searchID(1);
        semD.searchCost(30, 50);
        semD.searchDate("0", "1");
        semD.delete(1);
        semD.delete(1);
        semD.printID();
    }
}
