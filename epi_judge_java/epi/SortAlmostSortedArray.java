package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortAlmostSortedArray {

  public static List<Integer>
  sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    List<Integer> result = new ArrayList<>();
    /*for(int i=0;i<k&&sequence.hasNext();i++){
      pq.add(sequence.next());
    }

    while (sequence.hasNext()){
      pq.add(sequence.next());
      int kPlus1Smallest = pq.poll();
      result.add(kPlus1Smallest);
    }*/

    while (sequence.hasNext()){
      pq.add(sequence.next());
      if(pq.size()>k) {
        int kPlus1Smallest = pq.poll();
        result.add(kPlus1Smallest);
      }
    }

    while (!pq.isEmpty()){
      result.add(pq.poll());
    }


    return result;
  }
  @EpiTest(testDataFile = "sort_almost_sorted_array.tsv")
  public static List<Integer>
  sortApproximatelySortedDataWrapper(List<Integer> sequence, int k) {
    return sortApproximatelySortedData(sequence.iterator(), k);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortAlmostSortedArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
