package RealWorldApplications;

import java.io.File;

public class ListFilesInFolder {
    public static void main(String[] args) {
        // You can change the folder path here or pass it as a command-line argument
        String folderPath = "";

        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path: " + folderPath);
            return;
        }

        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files found in the folder.");
            return;
        }

        System.out.println("Files in folder: " + folderPath);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
