//my necessary libraries
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> rss = new ArrayList<>();
    private static final String FILENAME = "rss.txt";

    public static void main(String[] args) {
        loadUMLs();

        Scanner scanner = new Scanner(System.in);
         //guide of RSS
        while(true) {
            System.out.println("Enter 1 to add a UML");
            System.out.println("Enter 2 to remove a UML");
            System.out.println("Enter 3 to show all UMLs");
            System.out.println("Enter 4 to exit");

            int selection = scanner.nextInt();
         //define cases
            switch(selection) {
                case 1:
                    System.out.println("Enter the UML to add:");
                    scanner.nextLine();
                    String newUML = scanner.nextLine();
                    if(rss.contains(newUML)) {
                        System.out.println("UML already exists.");
                    } else {
                        rss.add(newUML);
                        saveUMLs();
                        System.out.println("UML added successfully.");
                    }
                    break;

                case 2:
                    System.out.println("Enter the UML name to remove:");
                    scanner.nextLine();
                    String removeUML = scanner.nextLine();
                    if(rss.contains(removeUML)) {
                        rss.remove(removeUML);
                        saveUMLs();
                        System.out.println("UML removed successfully.");
                    } else {
                        System.out.println("UML does not exist.");
                    }
                    break;

                case 3:
                    System.out.println("All existing UMLs:");
                    for(String uml : rss) {
                        System.out.println(uml);
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("ERROR : Invalid choice. Please try again.");
            }
        }
    }
    //save all UMLs
    private static void saveUMLs() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (String uml : rss) {
                writer.println(uml);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadUMLs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rss.add(line);
            }
        } catch (IOException e) {

        }
    }
}