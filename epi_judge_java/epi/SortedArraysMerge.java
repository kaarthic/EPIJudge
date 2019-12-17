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
    ArrayList<Iterator<Integer>> ali = new ArrayList<>();
    List<Integer> al = new ArrayList<>();
    sortedArrays.forEach(li->{
      ali.add(li.iterator());
    });

    PriorityQueue<ArrayPosition> pq = new PriorityQueue<>();
    final int idx = 0;

    for(int i=0;i<ali.size();i++){
      if(ali.get(i).hasNext())
        pq.add(new ArrayPosition(ali.get(i).next(),i));
    }
    /*ali.forEach(i->{
      if(i.hasNext())
      pq.add(new ArrayPosition(i.next(), idx++));
    });*/


    //Get the min
    ArrayPosition min = pq.poll();

    //

    // TODO - you fill in here.
    return null;
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
