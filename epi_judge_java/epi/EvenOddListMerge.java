package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class EvenOddListMerge {
  @EpiTest(testDataFile = "even_odd_list_merge.tsv")

  /*
  unsolved - time used: 23 mins
   */
  public static ListNode<Integer> evenOddMerge(ListNode<Integer> L) {
    if(L == null) return null;

    ListNode<Integer> even = L;
    ListNode<Integer> odd = L.next;
    ListNode<Integer> evenHead = even;
    ListNode<Integer> oddHead= odd;

    //0 1 2 3

    while (odd!=null) {
      even.next = odd.next;
      even = even.next;

      if(even!=null) {
        odd.next = even.next;
        odd = odd.next;
      }

    }
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EvenOddListMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
