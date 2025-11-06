//Q1
import java.io.*;

public class FileAnalysis {
    public static void main(String[] args) {
    	String inputFile = "C:\\Users\\LOKESHRAJ M\\OOP Lab\\data.txt";
        String reportFile = "report.txt";

        try {
            // Clear old report file
            new FileWriter(reportFile, false).close();

            System.out.println("=== Using Character Stream ===");
            analyzeUsingCharacterStream(inputFile, reportFile);

            System.out.println("\n=== Using Byte Stream ===");
            analyzeUsingByteStream(inputFile, reportFile);

            System.out.println("\n Both results saved successfully in '" + reportFile + "'.");

        } catch (IOException e) {
            System.out.println("Error initializing report file: " + e.getMessage());
        }
    }

    // ---------- CHARACTER STREAM ----------
    public static void analyzeUsingCharacterStream(String inputFile, String reportFile) {
        int charCount = 0, wordCount = 0, lineCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty())
                    wordCount += words.length;
            }

            // Display on console
            System.out.println("Characters: " + charCount);
            System.out.println("Words     : " + wordCount);
            System.out.println("Lines     : " + lineCount);

            // Append report
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(reportFile, true))) {
                bw.write("=== Report using Character Stream ===\n");
                bw.write("Total Characters: " + charCount + "\n");
                bw.write("Total Words     : " + wordCount + "\n");
                bw.write("Total Lines     : " + lineCount + "\n");
                bw.write("------------------------------------\n");
            }

        } catch (IOException e) {
            System.out.println("Error (Character Stream): " + e.getMessage());
        }
    }

    // ---------- BYTE STREAM ----------
    public static void analyzeUsingByteStream(String inputFile, String reportFile) {
        int charCount = 0, wordCount = 0, lineCount = 0;
        StringBuilder content = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(inputFile)) {
            int b;
            while ((b = fis.read()) != -1) {
                charCount++;
                content.append((char) b);
            }

            String text = content.toString();
            String[] lines = text.split("\r?\n");
            lineCount = lines.length;

            for (String line : lines) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty())
                    wordCount += words.length;
            }

            // Display on console
            System.out.println("Characters: " + charCount);
            System.out.println("Words     : " + wordCount);
            System.out.println("Lines     : " + lineCount);






            // Append report
            try (FileOutputStream fos = new FileOutputStream(reportFile, true)) {
                String report = "=== Report using Byte Stream ===\n" +
                                "Total Characters: " + charCount + "\n" +
                                "Total Words     : " + wordCount + "\n" +
                                "Total Lines     : " + lineCount + "\n" +
                                "------------------------------------\n";
                fos.write(report.getBytes());
            }

        } catch (IOException e) {
            System.out.println("Error (Byte Stream): " + e.getMessage());
        }
    }
}



 
//Q2

import java.io.*; import java.util.*;
public class FileMenuApplication { public static void main(String[] args) {
Scanner sc = new Scanner(System.in); int choice;
do {
System.out.println("\n===== FILE OPERATIONS MENU ====="); System.out.println("1. Create a new file");
System.out.println("2. Rename a file"); System.out.println("3. Delete a file"); System.out.println("4. Create a directory"); System.out.println("5. Find absolute path of a file");
System.out.println("6. Display all file names of a directory"); System.out.println("7. Exit");
System.out.print("Enter your choice: "); choice = sc.nextInt();
sc.nextLine(); // consume newline


switch (choice) { case 1:
 
System.out.print("Enter file name to create: "); String createName = sc.nextLine();
File createFile = new File(createName); try {
if (createFile.createNewFile())
System.out.println("File created successfully: " + createFile.getName()); else
System.out.println("File already exists.");
} catch (IOException e) {
System.out.println("Error creating file: " + e.getMessage());
}
break; case 2:
System.out.print("Enter current file name: "); String oldName = sc.nextLine(); System.out.print("Enter new file name: "); String newName = sc.nextLine();
File oldFile = new File(oldName); File newFile = new File(newName); if (oldFile.renameTo(newFile))
System.out.println("File renamed successfully."); else
System.out.println("Rename failed. File may not exist."); break;
 
case 3:
System.out.print("Enter file name to delete: "); String deleteName = sc.nextLine();
File deleteFile = new File(deleteName); if (deleteFile.delete())
System.out.println("File deleted successfully."); else
System.out.println("Deletion failed. File may not exist."); break;
case 4:
System.out.print("Enter directory name to create: "); String dirName = sc.nextLine();
File dir = new File(dirName); if (dir.mkdir())
System.out.println("Directory created successfully."); else
System.out.println("Failed to create directory. It may already exist."); break;
case 5:
System.out.print("Enter file name: "); String pathName = sc.nextLine(); File pathFile = new File(pathName);
System.out.println("Absolute Path: " + pathFile.getAbsolutePath()); break;
 
case 6:
System.out.print("Enter directory name: "); String listDir = sc.nextLine();
File list = new File(listDir); if (list.isDirectory()) {
String[] files = list.list();
System.out.println("Files in directory '" + listDir + "':"); for (String file : files) {
System.out.println(file);
}
} else {
System.out.println("Directory not found or invalid path.");
}
break; case 7:
System.out.println("Exiting program... Thank you!"); break;
default:
System.out.println("Invalid choice. Try again!");
}
} while (choice != 7); sc.close();
}
}



