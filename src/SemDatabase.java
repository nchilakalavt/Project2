public class SemDatabase {
    private int worldSize;
    private BST<Integer, Seminar> binSearchTreeID = new BST<Integer, Seminar>();
    private BST<Integer, Seminar> binSearchTreeLoc =
        new BST<Integer, Seminar>();
    private BST<Integer, Seminar> binSearchTreeCost =
        new BST<Integer, Seminar>();
    private BST<String, Seminar> binSearchTreeDate = new BST<String, Seminar>();
    private BST<String, Seminar> binSearchTreeKey = new BST<String, Seminar>();

    public SemDatabase(int w) {
        worldSize = w;
    }


    public void insert(Seminar sem) {
        binSearchTreeID.idInsert(sem.id(), sem);
        binSearchTreeCost.insert(sem.cost(), sem);
        binSearchTreeDate.insert(sem.date(), sem);
        String semKeyString = "";
        for (int i = 0; i < sem.keywords().length; i++) {
            semKeyString += sem.keywords()[i];
        }
        binSearchTreeKey.insert(semKeyString, sem);
    }


    public Seminar searchID(int key) {
        if (binSearchTreeID.find(key) == null) {
            return null;
        }
        return binSearchTreeID.find(key).value().value();
    }


    public String searchCost(int low, int high) {
        
        return binSearchTreeCost.findDupCost(binSearchTreeCost.getRoot(), new BST<Integer, Seminar>(), low, high);
    }


    public String searchKeyword(String keyword) {
        return binSearchTreeKey.findKeywords(binSearchTreeKey.getRoot(), keyword, "", 0);
    }


    public void searchLocation(int x, int y, double r) {

    }


    public void searchDate(int firstT, int secondT) {

    }


    public void delete(int key) {

    }


    public void printDate() {

    }


    public void printKeyword() {

    }


    public void printLocation() {

    }


    public void printCost() {

    }


    public void printID() {

    }
    
    public String treeToString() {
        return binSearchTreeCost.preOrderTraverseToString(binSearchTreeCost.getRoot(), "", 0);
    }
}
