package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class SearchRowColSortedMatrix {
  @EpiTest(testDataFile = "search_row_col_sorted_matrix.tsv")

  public static boolean matrixSearch(List<List<Integer>> A, int x) {
    if(A == null || A.size() == 0) return false;
    int rowIdx = A.size()-1;
    int colIdx = 0;

    while (rowIdx>=0 && colIdx<A.get(0).size()) {
      if (A.get(rowIdx).get(colIdx) < x) colIdx++;
      else if (A.get(rowIdx).get(colIdx) > x) rowIdx--;
      else return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchRowColSortedMatrix.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
