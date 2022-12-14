package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

  private static final String RESOURCES = "2022/src/main/resources/";

  private FileUtil() {
    throw new IllegalArgumentException("Utility class. Should not be instantiated.");
  }

  public static List<String> readLines(String filePath) {
    List<String> lines = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(RESOURCES + filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        lines.add(line);
      }
    } catch (FileNotFoundException e) {
      System.out.printf("File not found [%s]%n", filePath);
    } catch (IOException e) {
      System.out.printf("File IO exception [%s]%n", filePath);
    }
    return lines;
  }

  public static String readWholeFile(String filePath){
    StringBuilder wholeFile = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(RESOURCES + filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        wholeFile.append(line).append("\n");
      }
    } catch (FileNotFoundException e) {
      System.out.printf("File not found [%s]%n", filePath);
    } catch (IOException e) {
      System.out.printf("File IO exception [%s]%n", filePath);
    }
    return wholeFile.toString();
  }

  // ... Special readers can be added here if needed.
}
