package LAB;
import java.io.*;
import java.util.Scanner;

public class EXERCISE_9B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        File file;
        
        do {
            System.out.println("\n===== FILE HANDLING MENU =====");
            System.out.println("1. Create a new file");
            System.out.println("2. Rename a file");
            System.out.println("3. Delete a file");
            System.out.println("4. Create a new directory");
            System.out.println("5. Find absolute path of a file");
            System.out.println("6. Display all files in a directory");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter file name to create: ");
                    String fileName = sc.nextLine();
                    file = new File(fileName);
                    try {
                        if (file.createNewFile())
                            System.out.println("File created successfully: " + file.getName());
                        else
                            System.out.println("File already exists.");
                    } catch (IOException e) {
                        System.out.println("Error creating file: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter current file name: ");
                    String oldName = sc.nextLine();
                    System.out.print("Enter new file name: ");
                    String newName = sc.nextLine();

                    File oldFile = new File(oldName);
                    File newFile = new File(newName);

                    if (oldFile.renameTo(newFile))
                        System.out.println("File renamed successfully!");
                    else
                        System.out.println("Rename failed. Make sure file exists.");
                    break;

                case 3:
                    System.out.print("Enter file name to delete: ");
                    String deleteName = sc.nextLine();
                    file = new File(deleteName);
                    if (file.delete())
                        System.out.println("File deleted successfully.");
                    else
                        System.out.println("Failed to delete the file.");
                    break;

                case 4:
                    System.out.print("Enter directory name to create: ");
                    String dirName = sc.nextLine();
                    file = new File(dirName);
                    if (file.mkdir())
                        System.out.println("Directory created successfully.");
                    else
                        System.out.println("Failed to create directory (may already exist).");
                    break;

                case 5:
                    System.out.print("Enter file name to find absolute path: ");
                    String absFile = sc.nextLine();
                    file = new File(absFile);
                    System.out.println("Absolute Path: " + file.getAbsolutePath());
                    break;

                case 6:
                    System.out.print("Enter directory name to list files: ");
                    String listDir = sc.nextLine();
                    file = new File(listDir);
                    if (file.isDirectory()) {
                        String[] files = file.list();
                        System.out.println("\nFiles in directory '" + listDir + "':");
                        for (String f : files)
                            System.out.println(" - " + f);
                    } else {
                        System.out.println("Directory not found!");
                    }
                    break;

                case 7:
                    System.out.println("Exiting program... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
