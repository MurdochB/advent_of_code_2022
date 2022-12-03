package challenge.days;

import challenge.Solution;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class D01 extends Solution {

  private static final String INPUT_FILE = "input-01.txt";

  private D01(String inputFile) {
    super(inputFile);
  }

  public static void main(String[] args) {
    D01 solution = new D01(INPUT_FILE);
    solution.run();
  }

  public void partOne() {
    System.out.println("# Part 1 #");
    int currentMax = 0;
    int thisElf = 0;
    for (String line : lines) {
      if (!line.equals("")) {
        thisElf += Integer.parseInt(line);
      } else {
        if (thisElf > currentMax) {
          currentMax = thisElf;
        }
        thisElf = 0;
      }
    }
    System.out.println(currentMax);
  }

  public void partTwo() {
    System.out.println("# Part 2 #");
    List<Integer> totalCalories = new ArrayList<>();

    int thisElf = 0;
    for (String line : lines) {
      if (!line.equals("")) {
        thisElf += Integer.parseInt(line);
      } else {
        totalCalories.add(thisElf);
        thisElf = 0;
      }

    }
    int top3TotalCalories = totalCalories.stream()
        .sorted(Collections.reverseOrder())
        .limit(3)
        .mapToInt(Integer::intValue)
        .sum();
    System.out.println(top3TotalCalories);
  }
}
