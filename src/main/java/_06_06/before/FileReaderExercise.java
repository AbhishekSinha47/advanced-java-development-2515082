package _06_06.before;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderExercise {

    // This method should return the first line of BufferedReaderVsScanner.txt.
    String getFirstLine() {
        String firstLine = "";
        try (Scanner scanner = new Scanner(new FileReader("src/main/java/_06_06/BufferedReaderVsScanner.txt"))) {
            firstLine = scanner.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstLine;
    }

    // This method should return all of the content of BufferedReaderVsScanner.txt
    // as a single String.
    String getWholeFile() {
        String wholeFile = "";
        try (BufferedReader reader
                     = new BufferedReader(new FileReader("src/main/java/_06_05/BufferedReaderVsScanner.txt"))) {
            StringBuilder stringBuilder = new StringBuilder();
            reader.lines().forEach(stringBuilder::append);
            wholeFile = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wholeFile;
    }

}
