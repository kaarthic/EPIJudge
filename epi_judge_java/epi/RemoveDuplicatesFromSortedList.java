package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class RemoveDuplicatesFromSortedList {
  @EpiTest(testDataFile = "remove_duplicates_from_sorted_list.tsv")

  public static ListNode<Integer> removeDuplicates(ListNode<Integer> L) {
    if(L == null) return L;

    ListNode<Integer> curr = L;
    ListNode<Integer> next = L.next;

    while (next!=null) {
      if (next.data == curr.data) {
        curr.next = next.next;
        next = next.next;
      } else {
        curr = next;
        next = next.next;
      }
    }

    return L;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RemoveDuplicatesFromSortedList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
