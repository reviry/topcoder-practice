/*
 * SRM478 Div 2 Level 1
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class KiwiJuiceEasy {
  public static int[] thePouring(int[] capacities, int[] bottles,
                                 int[] fromId, int[] toId) {
    for (int i = 0; i < fromId.length; i++) {
      int sum = bottles[fromId[i]] + bottles[toId[i]];
      bottles[toId[i]] = Math.min(sum, capacities[toId[i]]);
      bottles[fromId[i]] = sum - bottles[toId[i]];
    }

    return bottles;
  }

  public static void main(String[] args) {
    try (BufferedReader br = Files.newBufferedReader(
          Paths.get("../testcase/KiwiJuiceEasy.txt"),
          StandardCharsets.UTF_8)) {
      String line;
      String[] data;
      int[] capacities = null;
      int[] bottles = null;
      int[] fromId = null;
      int[] toId = null;
      int[] answer = null;

      int count = 0;
      while ((line = br.readLine()) != null) {
        data = line.split(" ");
        count++;
        if (count == 1) {
          capacities = new int[data.length];
          for (int i = 0; i < data.length; i++) {
            capacities[i] = Integer.parseInt(data[i]);
          }
        } else if (count == 2) {
          bottles = new int[data.length];
          for (int i = 0; i < data.length; i++) {
            bottles[i] = Integer.parseInt(data[i]);
          }
        } else if (count == 3) {
          fromId = new int[data.length];
          for (int i = 0; i < data.length; i++) {
            fromId[i] = Integer.parseInt(data[i]);
          }
        } else if (count == 4) {
          toId = new int[data.length];
          for (int i = 0; i < data.length; i++) {
            toId[i] = Integer.parseInt(data[i]);
          }
        } else {
          answer = new int[data.length];
          for (int i = 0; i < data.length; i++) {
            answer[i] = Integer.parseInt(data[i]);
          }
          count = 0;

          long start = System.nanoTime();

          int[] result = thePouring(capacities, bottles, fromId, toId);

          long end = System.nanoTime();

          boolean flag = true;
          for (int i = 0; i < answer.length; i++) {
            if (result[i] != answer[i]) {
              flag = false;
              break;
            }
          }

          if (flag) {
            System.out.println("PASS!!");
          } else {
            System.out.println("FAILURE!!");
          }

          System.out.println("Time: " + (end - start) / 1000000f + "[ms]");
        }
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
