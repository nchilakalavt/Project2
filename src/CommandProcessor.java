import java.util.Scanner;
import java.io.File;

public class CommandProcessor {

    private int id;
    private String title;
    private String date; // Seminar date
    private int length; // Seminar length
    private String[] keywords; // Seminar keywords
    private short x; // Seminar x coord
    private short y; // Seminar y coord
    private String desc; // Seminar description
    private int cost; // Seminar cost
    private int worldSize;

    public CommandProcessor(String w) {
        this.worldSize = Integer.parseInt(w);

    }


    /**
     * method to parse through the file
     * 
     * @param filename
     *            to parse through
     */
    public void parsing(String filename) {
        try {
            SemDatabase semData = new SemDatabase(worldSize);
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
                String cmd = sc.next();
                // switch case based on what string command is read
                switch (cmd) {
                    case "insert":
                        id = sc.nextInt();
                        sc.nextLine();
                        title = sc.nextLine();
                        date = sc.next();
                        length = sc.nextInt();
                        x = sc.nextShort();
                        y = sc.nextShort();
                        cost = sc.nextInt();
                        sc.nextLine();
                        String[] key = sc.nextLine().trim().split("\\s+");
                        keywords = new String[key.length];
                        for (int i = 0; i < key.length; i++) {
                            if (!key[i].equals(" ")) {
                                keywords[i] = (key[i].trim());
                            }
                        }
                        desc = sc.nextLine().trim();
                        Seminar sem = new Seminar(id, title, date, length, x, y,
                            cost, keywords, desc);
                        semData.insert(sem);
                        break;
                    case "search":
                        String command = sc.next();
                        if (command.equals("ID")) {
                            int searchId = sc.nextInt();
                            semData.searchID(searchId);
                        }
                        else if (command.equals("cost")) {
                            int lowEnd = sc.nextInt();
                            int highEnd = sc.nextInt();
                            semData.searchCost(lowEnd, highEnd);
                        }
                        else if (command.equals("date")) {
                            String startDate = sc.next();
                            String endDate = sc.next();
                            semData.searchDate(startDate, endDate);

                        }
                        else if (command.equals("keyword")) {
                            String s = sc.nextLine().trim();
                            semData.searchKeyword(s);
                        }
                        else if (command.equals("location")) {
                            int startDate = sc.nextInt();
                            int endDate = sc.nextInt();
                            double radius = sc.nextDouble();
                        }
                        break;


                    case "delete":
                        id = sc.nextInt();
                        semData.delete(id);
                        break;
                    case "print":
                        String command2 = sc.next();
                        if (command2.equals("ID")) {
                            semData.printID();
                        }
                        else if (command2.equals("cost")) {
                            semData.printCost();
                        }
                        else if (command2.equals("date")) {
                            semData.printDate();
                        }
                        else if (command2.equals("keyword")) {
                            semData.printKeyword();
                        }
                        else if (command2.equals("location")) {
                        }

                        break;
                    default:
                        System.out.println("Unrecognized input: " + cmd);
                        break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
