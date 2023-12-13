package _07_05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FilesExercise {

    public static void main(String[] args) {
        // Create a new empty file called example.txt inside folderA
        Path folderPath = Paths.get("src/main/java/_07_05/folderA");
        Path filePath = Paths.get("src/main/java/_07_05/folderA/example.txt");
        try {
            if (Files.notExists(folderPath)) {
                Files.createDirectory(folderPath);
            }
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Copy the file to folderB
        Path folderPathB = Paths.get("src/main/java/_07_05/folderB");
        Path filePathB = Paths.get("src/main/java/_07_05/folderB/example.txt");
        try {
            if (Files.notExists(folderPathB)) {
                Files.createDirectory(folderPathB);
            }
            if (Files.notExists(filePathB)) {
                Files.copy(filePath, filePathB);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // List the contents of folderB to check that your file is in there
        try {
            List<Path> fileList = Files.list(Paths.get("src/main/java/_07_05/folderB"))
                       .filter(file -> !Files.isDirectory(file)
                               && file.getFileName().toString().equals("example.txt"))
                    .collect(Collectors.toList());
            if (!fileList.isEmpty()) {
                System.out.println("Yes the file is present.");
            } else {
                System.out.println("No, the file is not present.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
