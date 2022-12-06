package challenge.days;

import challenge.Solution;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D06 extends Solution {

  private static final String INPUT_FILE = "input-06.txt";

  private D06(String inputFile) {
    super(inputFile);
  }

  public static void main(String[] args) {
    D06 solution = new D06(INPUT_FILE);
    solution.run();
  }

  public void partOne() {
    System.out.println("# Part 1 #");

    int signalSize = 4;
    System.out.println(getFirstTimeSignal(signalSize));

  }

  public void partTwo() {
    System.out.println("# Part 2 #");

    int signalSize = 14;
    System.out.println(getFirstTimeSignal(signalSize));
  }

  private int getFirstTimeSignal(int signalSize) {
    for (String line : lines) {
      for (int i = 0; i < line.length() - signalSize - 1; i++) {
        String checkMsg = line.substring(i, i + signalSize);
        if (uniqCharsInString(checkMsg)) {
          return i + signalSize;
        }
      }
    }
    return -1;
  }

  private boolean uniqCharsInString(String string) {
    int length = string.length();
    String[] split = string.split("");
    Set<String> set = new HashSet<>(List.of(split));
    return length == set.size();
  }
}
