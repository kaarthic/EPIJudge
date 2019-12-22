package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class SearchFirstKey {
  @EpiTest(testDataFile = "search_first_key.tsv")

  public static int searchFirstOfK(List<Integer> A, int k) {
    if(A==null || A.size()==0) return -1;
    int left = 0, right = A.size()-1;
    //if equal -> cut right but mid might be a candidate
    //if mid<k -> cut left
    //if mid>k -> cut right
    while(left<right) {
      int mid = (left + right) / 2;
      if (A.get(mid) == k) {
        right = mid;
      } else if (A.get(mid) < k) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return (A.get(left)==k)?left:-1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchFirstKey.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
