/*
 * SRM478 Div 2 Level 1
 */

public class KiwiJuiceEasy {
  public static int[] thePouring(int[] capacities, int[] bottles,
                          int[] fromId, int[] toId) {
    for (int i = 0; i < fromId.length; i++) {
      if (bottles[fromId[i]] + bottles[toId[i]] <= capacities[toId[i]]) {
        bottles[toId[i]] += bottles[fromId[i]];
        bottles[fromId[i]] = 0;
      } else {
        bottles[fromId[i]] -= capacities[toId[i]] - bottles[toId[i]];
        bottles[toId[i]] = capacities[toId[i]];
      }
    }

    return bottles;
  }

  public static void main(String[] args) {
    int[] capacities = {30, 20, 10};
    int[] bottles = {10, 5, 5};
    int[] fromId = {0, 1, 2};
    int[] toId = {1, 2, 0};
    int[] answer = thePouring(capacities, bottles, fromId, toId);
    for (int i = 0; i < answer.length; i++) {
      System.out.println(answer[i]);
    }
  }
}
