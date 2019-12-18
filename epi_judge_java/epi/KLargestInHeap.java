package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.BiPredicate;
public class KLargestInHeap {
  @EpiTest(testDataFile = "k_largest_in_heap.tsv")

  public static List<Integer> kLargestInBinaryHeap(List<Integer> A, int k) {
    if(k<=0 || k>A.size()) return Collections.EMPTY_LIST;

    PriorityQueue<IndexValue> maxPQ  = new PriorityQueue<>((i1,i2)->{
      return i2.value-i1.value;
    });

    maxPQ.add(new IndexValue(0, A.get(0)));
    List<Integer> result = new ArrayList<>();
    for(int i=0;i<k;i++){
      IndexValue curr = maxPQ.poll();
      result.add(curr.value);

      int leftChildIndex = 2*curr.index+1;
      int righChildIndex = 2*curr.index+2;

      if(leftChildIndex<A.size()){
        maxPQ.add(new IndexValue(leftChildIndex, A.get(leftChildIndex)));
      }

      if(righChildIndex<A.size()){
        maxPQ.add(new IndexValue(righChildIndex, A.get(righChildIndex)));
      }
    }
    return result;
  }

  static class IndexValue{
    int index;
    int value;

    IndexValue(int index, int value){
      this.index = index;
      this.value = value;
    }
  }

  @EpiTestComparator
  public static BiPredicate<List<Integer>, List<Integer>> comp =
      (expected, result) -> {
    if (result == null) {
      return false;
    }
    Collections.sort(expected);
    Collections.sort(result);
    return expected.equals(result);
  };

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "KLargestInHeap.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
