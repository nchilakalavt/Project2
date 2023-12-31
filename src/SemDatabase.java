public class SemDatabase {
    private int worldSize;
    private BST<Integer, Seminar> binSearchTreeID = new BST<Integer, Seminar>();
    private BST<Integer, Seminar> binSearchTreeCost =
        new BST<Integer, Seminar>();
    private BST<String, Seminar> binSearchTreeDate = new BST<String, Seminar>();
    private BST<String, Seminar> binSearchTreeKey = new BST<String, Seminar>();

    public SemDatabase(int w) {
        worldSize = w;
    }


    public void insert(Seminar sem) {
        if (sem.x() < 0 || sem.y() < 0 || sem.x() >= worldSize || sem
            .y() >= worldSize) {
            System.out.println("Insert FAILED - Bad x, y coordinates: " + sem
                .x() + ", " + sem.y());
        }
        else if (binSearchTreeID.idInsert(sem.id(), sem)) {
            binSearchTreeCost.insert(sem.cost(), sem);
            binSearchTreeDate.insert(sem.date(), sem);
            for (int i = 0; i < sem.keywords().length; i++) {
                binSearchTreeKey.insert(sem.keywords()[i], sem);
            }
            System.out.println("Successfully inserted record with ID " + sem
                .id() + "\n" + sem.toString());
        }
        else {

        }
    }


    public void searchID(int key) {
        if (binSearchTreeID.find(key) != null) {
            System.out.println("Found record with ID " + key + ":");
            System.out.println(binSearchTreeID.find(key).value().value().toString());
        }
        else {
            System.out.println("There is no record with ID " + key);
        }
    }


    public void searchCost(int low, int high) {
        System.out.println("Seminars with costs in range " + low + " to " + high
            + ":");
        binSearchTreeCost.printRange(low, high);
    }


    public void searchKeyword(String keyword) {
        System.out.println("Seminars matching keyword " + keyword + ":");
        if (binSearchTreeKey.getNodeCount() != 0) {
            binSearchTreeKey.printRange( keyword,
                keyword);
        }
    }


    public void searchDate(String firstT, String secondT) {
        System.out.println("Seminars with dates in range " + firstT + " to "
            + secondT + ":");
        binSearchTreeDate.printRange(firstT, secondT);
    }


    public void delete(int key) {
        if (binSearchTreeID.find(key) != null) {
            Seminar sem = binSearchTreeID.find(key).value().value();
            binSearchTreeID.remove(key, sem);
            binSearchTreeCost.remove(sem.cost(), sem);
            binSearchTreeDate.remove(sem.date(), sem);
            for (int i = 0; i < sem.keywords().length; i++) {
                binSearchTreeKey.remove(sem.keywords()[i], sem);
            }
            System.out.println("Record with ID " + key + " successfully deleted");
        }
        else {
            System.out.println("Delete FAILED -- There is no record with ID "
                + key);
        }
    }


    public void printDate() {
        System.out.println("Date Tree:");
        if (binSearchTreeDate.getNodeCount() == 0) {
            System.out.println("This tree is empty");
        }
        else {
            binSearchTreeDate.print();
            System.out.println("Number of records: " + binSearchTreeDate
                .getNodeCount());

        }

    }


    public void printKeyword() {
        System.out.println("Keyword Tree:");
        if (binSearchTreeKey.getNodeCount() == 0) {
            System.out.println("This tree is empty");
        }
        else {
            binSearchTreeKey.print();
            System.out.println("Number of records: " + binSearchTreeKey
                .getNodeCount());
        }

    }


    public void printCost() {
        System.out.println("Cost Tree:");
        if (binSearchTreeCost.getNodeCount() == 0) {
            System.out.println("This tree is empty");
        }
        else {
            binSearchTreeCost.print();
            System.out.println("Number of records: " + binSearchTreeCost
                .getNodeCount());
        }
    }


    public void printID() {
        System.out.println("ID Tree:");
        if (binSearchTreeID.getNodeCount() == 0) {
            System.out.println("This tree is empty");
        }
        else {
            binSearchTreeID.print();
            System.out.println("Number of records: " + binSearchTreeID
                .getNodeCount());
        }
    }
}
