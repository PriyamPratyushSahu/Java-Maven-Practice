package dailyNeedClass;

import java.io.File;

public class ListFilesInFolder {
    public static void main(String[] args) {
        // Provide folder path here
        String folderPath = "";

        File folder = new File(folderPath);

        // Check if the path exists and is a directory
        if (folder.exists() && folder.isDirectory()) {

            File[] files = folder.listFiles();

            if (files != null && files.length > 0) {
                System.out.println("Files in the folder:");

                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("Folder is empty.");
            }

        } else {
            System.out.println("Invalid folder path.");
        }
    }
}
