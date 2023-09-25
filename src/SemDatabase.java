public class SemDatabase {
    private int worldSize;
    private BST<Integer, Seminar> binSearchTreeID = new BST<Integer, Seminar>();
    private BST<Integer, Seminar> binSearchTreeLoc = new BST<Integer, Seminar>();
    private BST<Integer, Seminar> binSearchTreeCost = new BST<Integer, Seminar>();
    private BST<String, Seminar> binSearchTreeDate = new BST<String, Seminar>();
    private BST<String, Seminar> binSearchTreeKey = new BST<String, Seminar>();
    
    public SemDatabase(int w) {
        worldSize = w;
    }

    public void insert(Seminar sem) {
        binSearchTreeID.idInsert(sem.id(), sem);
        binSearchTreeCost.insert(sem.cost(), sem);
        binSearchTreeDate.insert(sem.date(), sem);
        binSearchTreeKey.insert(sem.keywords().toString(), sem);
    }
    
    public Seminar searchID(int key) {
        if (binSearchTreeID.find(key) == null) {
            return null;
        }
        return binSearchTreeID.find(key).value().value();
    }


    public Seminar[] searchCost(int low, int high) {
        
        int retArraySize = 0;
        int y = 0;
        int dupCounter;
        for (int i = low; i<= high; i++) {
            //Seminar checkSem = binSearchTreeCost.find(i).value().value();
            if (binSearchTreeCost.find(i) != null) {
                dupCounter = binSearchTreeCost.isDuplicate(binSearchTreeCost.find(i));
                while (dupCounter > 0) {
                    retArraySize++;
                    dupCounter--;
                }
            }
        }
        Seminar[] semArray = new Seminar[retArraySize];
        
        for (int i = low; i<= high; i++) {
            //Seminar checkSem = binSearchTreeCost.find(i).value().value();
            while (binSearchTreeCost.find(i) != null) {
                semArray[y] = binSearchTreeCost.find(i).value().value();;
                y++;
            }
        }
        return semArray;
    }


    public Seminar searchKeyword(String keyword) {
        return binSearchTreeKey.findKeyword(keyword).value().value();
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
}
