package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortedArraysMerge {
  @EpiTest(testDataFile = "sorted_arrays_merge.tsv")

  public static List<Integer>
  mergeSortedArrays(List<List<Integer>> sortedArrays) {
    ArrayList<Iterator<Integer>> iterPool = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    sortedArrays.forEach(li->{
      iterPool.add(li.iterator());
    });

    PriorityQueue<ArrayPosition> minPQ = new PriorityQueue<>((o1, o2) -> {
      return o1.value-o2.value;
    });
    final int idx = 0;

    for(int i=0;i<iterPool.size();i++){
      if(iterPool.get(i).hasNext())
        minPQ.add(new ArrayPosition(iterPool.get(i).next(),i));
    }
    /*ali.forEach(i->{
      if(i.hasNext())
      pq.add(new ArrayPosition(i.next(), idx++));
    });*/

    while (!minPQ.isEmpty()) {
      //Get the min
      ArrayPosition min = minPQ.poll();

      //Add the min to the result
      result.add(min.value);

      if (iterPool.get(min.arrId).hasNext()) {
        minPQ.add(new ArrayPosition(iterPool.get(min.arrId).next(), min.arrId));
      }
    }

    // TODO - you fill in here.
    return result;
  }

  static class ArrayPosition{
    int value;
    int arrId;

    ArrayPosition(int value, int arrId){
      this.value = value;
      this.arrId = arrId;
    }
  }
  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedArraysMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
