/*
 * SRM494 Div 2 Level 1
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InterestingParty {
  public static int bestInvitation(String[] first, String[] second) {
    int answer = 0;
    for (int i = 0; i < first.length; i++) {
      int f = 0;
      int s = 0;
      for (int j = 0; j < first.length; j++) {
        if (first[i].equals(first[j])) f++;
        if (first[i].equals(second[j])) f++;
        if (second[i].equals(first[j])) s++;
        if (second[i].equals(second[j])) s++;
      }
      answer = Math.max(f, answer);
      answer = Math.max(s, answer);
    }
    return answer;
  }

  public static void main(String[] args) {
    try(BufferedReader br = Files.newBufferedReader(
            Paths.get("../testcase/InterestingParty.txt"),
            StandardCharsets.UTF_8)) {
      String line;
      String[] first = null;
      String[] second = null;
      int answer;

      int count = 0;
      while ((line = br.readLine()) != null) {
        count++;
        if (count == 0) {
          first = line.split(" ");
        } else if (count == 1) {
          second = line.split(" ");
        } else {
          answer = Integer.parseInt(line);
          count = 0;

          long start = System.nanoTime();

          int result = bestInvitation(first, second);

          long end = System.nanoTime();

          if (answer == result) {
            System.out.println("PASS!!");
          } else {
            System.out.println("FAILURE!!");
          }

          System.out.println("Time: " + (end - start) / 1000000f + "[ms]");
        }
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
