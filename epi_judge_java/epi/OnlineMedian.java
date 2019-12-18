package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class OnlineMedian {
  public static List<Double> onlineMedian(Iterator<Integer> sequence) {
    List<Double> result = new ArrayList<>();
    //left PQ
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());

    //right PQ
    PriorityQueue<Integer> right = new PriorityQueue<>();

    while (sequence.hasNext()){
      /*
      Add to right
      Move the min from right to left
      if left becomes larger of the two, make the right larger

      if the left and right size are same, then the median is average of the polled elements from heap
      if the size is unequal, right would be the larger of the two, hence the median is from the right
       */
      int curr = sequence.next();
      right.add(curr);
      left.add(right.poll());

      if(left.size()>right.size()){
        right.add(left.poll());
      }

      //WARNING: Do not poll. Just peek at the element. Polling would make the element not available in the next iteration
      if(left.size()==right.size()){
        result.add((0.5*(left.peek()+right.peek())));
      }
      else {
        result.add(new Double(right.peek()));
      }

    }

    return result;
  }
  @EpiTest(testDataFile = "online_median.tsv")
  public static List<Double> onlineMedianWrapper(List<Integer> sequence) {
    return onlineMedian(sequence.iterator());
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "OnlineMedian.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
