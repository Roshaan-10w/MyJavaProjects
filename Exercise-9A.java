package LAB;
import java.io.*;

public class EXERCISE_9 {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\91999\\Desktop\\data.txt"; // Input file path
        String reportFile = "report.txt"; // Report file to store output

        try {
            // Clear previous content in report file
            new FileWriter(reportFile, false).close();

            System.out.println("=== USING CHARACTER STREAM ===");
            characterStreamAnalysis(inputFile, reportFile);

            System.out.println("\n=== USING BYTE STREAM ===");
            byteStreamAnalysis(inputFile, reportFile);

            System.out.println("\n Both reports saved successfully in '" + reportFile + "'.");

        } catch (IOException e) {
            System.out.println("Error while creating report file: " + e.getMessage());
        }
    }

    // ---------- CHARACTER STREAM METHOD ----------
    public static void characterStreamAnalysis(String inputFile, String reportFile) {
        int charCount = 0, wordCount = 0, lineCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            // Display result on console
            System.out.println("Characters : " + charCount);
            System.out.println("Words      : " + wordCount);
            System.out.println("Lines      : " + lineCount);

            // Write report to file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(reportFile, true))) {
                bw.write("=== REPORT USING CHARACTER STREAM ===\n");
                bw.write("Total Characters : " + charCount + "\n");
                bw.write("Total Words      : " + wordCount + "\n");
                bw.write("Total Lines      : " + lineCount + "\n");
                bw.write("--------------------------------------\n");
            }

        } catch (IOException e) {
            System.out.println("Error in Character Stream: " + e.getMessage());
        }
    }

    // ---------- BYTE STREAM METHOD ----------
    public static void byteStreamAnalysis(String inputFile, String reportFile) {
        int charCount = 0, wordCount = 0, lineCount = 0;
        StringBuilder content = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(inputFile)) {
            int b;
            while ((b = fis.read()) != -1) {
                charCount++;
                content.append((char) b);
            }

            String text = content.toString();
            String[] lines = text.split("\\r?\\n");
            lineCount = lines.length;

            for (String line : lines) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            // Display result on console
            System.out.println("Characters : " + charCount);
            System.out.println("Words      : " + wordCount);
            System.out.println("Lines      : " + lineCount);

            // Write report to file
            try (FileOutputStream fos = new FileOutputStream(reportFile, true)) {
                String report = "=== REPORT USING BYTE STREAM ===\n" +
                        "Total Characters : " + charCount + "\n" +
                        "Total Words      : " + wordCount + "\n" +
                        "Total Lines      : " + lineCount + "\n" +
                        "--------------------------------------\n";
                fos.write(report.getBytes());
            }

        } catch (IOException e) {
            System.out.println("Error in Byte Stream: " + e.getMessage());
        }
    }
}
