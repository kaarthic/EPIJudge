package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class SearchShiftedSortedArray {
  @EpiTest(testDataFile = "search_shifted_sorted_array.tsv")

  public static int searchSmallest(List<Integer> A) {
    int left = 0, right = A.size()-1;
    while (left<right){
      int mid = (left+right)/2;
      if(A.get(mid)<A.get(right)){
        right = mid;
      }else if(A.get(mid)>A.get(right)){
        left = mid+1;
      }else{
        //Since the elements are all distinct, there cannot be A.get(mid) == A.get(right)

      }
    }
    return right;// can be left as well since left=right
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchShiftedSortedArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
