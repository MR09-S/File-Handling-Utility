import java.io.*;
import java.util.Scanner;

public class FileOperations {

    // Method to write data to a file
    public static void writeFile(String filename, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(data);
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read data from a file
    public static void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify data in a file
    public static void modifyFile(String filename, String oldText, String newText) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            StringBuilder content = new StringBuilder();

            while (sc.hasNextLine()) {
                content.append(sc.nextLine().replace(oldText, newText)).append("\n");
            }
            sc.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(content.toString());
            writer.close();

            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String filename = scanner.nextLine();

        System.out.println("Choose operation: 1) Write 2) Read 3) Modify");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter data to write:");
                String data = scanner.nextLine();
                writeFile(filename, data);
                break;
            case 2:
                readFile(filename);
                break;
            case 3:
                System.out.println("Enter text to replace:");
                String oldText = scanner.nextLine();
                System.out.println("Enter new text:");
                String newText = scanner.nextLine();
                modifyFile(filename, oldText, newText);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
