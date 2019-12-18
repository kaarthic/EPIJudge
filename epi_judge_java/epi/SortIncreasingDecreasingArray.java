package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SortIncreasingDecreasingArray {
  @EpiTest(testDataFile = "sort_increasing_decreasing_array.tsv")

  public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
    List<List<Integer>> all = new ArrayList<>();
    List<Integer> al = new ArrayList<>();
    SeqType seqType = SeqType.INCREASING;
    for(int i=0;i<A.size()-1;i++){
      if(A.get(i)<=A.get(i+1)){
        if(seqType == SeqType.DECREASING){
          seqType = SeqType.INCREASING;
          Collections.reverse(al);
          all.add(new ArrayList<>(al));
          al = new ArrayList<>();
        }
        al.add(A.get(i));
      }else{
        if(seqType == SeqType.INCREASING){
          seqType = SeqType.DECREASING;
          all.add(new ArrayList<>(al));
          al = new ArrayList<>();
        }
        al.add(A.get(i));
      }
    }
/*
The prvious to last element would already started the increasing or decreasing seq.
So the last element is already a part of increasing or decreasing sequence
 */
    if(seqType == SeqType.INCREASING){
      al.add(A.get(A.size()-1));
    }else {
      al.add(A.get(A.size()-1));
      Collections.reverse(al);
    }
    all.add(new ArrayList<>(al));

    return SortedArraysMerge.mergeSortedArrays(all);
  }

  private static enum SeqType{
    INCREASING, DECREASING
  }
  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortIncreasingDecreasingArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
