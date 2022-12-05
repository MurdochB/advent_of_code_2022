package challenge.days;

import challenge.Solution;

public class D04 extends Solution {

  private static final String INPUT_FILE = "input-04.txt";

  private D04(String inputFile) {
    super(inputFile);
  }

  public static void main(String[] args) {
    D04 solution = new D04(INPUT_FILE);
    solution.run();
  }

  public void partOne() {
    System.out.println("# Part 1 #");
    int fullyWrapped = 0;

    for (String line : lines) {
      String[] split = line.split(",");
      String range1 = split[0];
      String range2 = split[1];

      if(rangeWrapsOtherRange(range1, range2))
        fullyWrapped++;
    }
    System.out.println(fullyWrapped);
  }

  private boolean rangeWrapsOtherRange(String range1, String range2) {
    int range1Start = Integer.parseInt(range1.split("-")[0]);
    int range1End = Integer.parseInt(range1.split("-")[1]);
    int range2Start = Integer.parseInt(range2.split("-")[0]);
    int range2End = Integer.parseInt(range2.split("-")[1]);
    if (range1Start == range2Start)
      return true;

    if (range1Start < range2Start)
      return range1End >= range2End;
    else
      return range2End >= range1End;
  }

  public void partTwo() {
    System.out.println("# Part 2 #");
    int overlapAtAll = 0;

    for (String line : lines) {
      String[] split = line.split(",");
      String range1 = split[0];
      String range2 = split[1];

      if(rangeOverlapsAtAll(range1, range2))
        overlapAtAll++;
    }
    System.out.println(overlapAtAll);
  }

  private boolean rangeOverlapsAtAll(String range1, String range2) {
    int range1Start = Integer.parseInt(range1.split("-")[0]);
    int range1End = Integer.parseInt(range1.split("-")[1]);
    int range2Start = Integer.parseInt(range2.split("-")[0]);
    int range2End = Integer.parseInt(range2.split("-")[1]);

    if (range1Start == range2Start)
      return true;

    if (range1Start < range2Start)
      return !(range1End < range2Start);
    else
      return !(range2End < range1Start);
  }

}
