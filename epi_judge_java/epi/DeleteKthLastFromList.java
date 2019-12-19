package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class DeleteKthLastFromList {
  @EpiTest(testDataFile = "delete_kth_last_from_list.tsv")

  // Assumes L has at least k nodes, deletes the k-th last node in L.
  public static ListNode<Integer> removeKthLast(ListNode<Integer> L, int k) {

    int steps = k+1;
    ListNode<Integer> dummy = new ListNode<>(0, null);

    dummy.next = L;
    ListNode<Integer> right = dummy;
    ListNode<Integer> left = dummy;

    while (steps-->0){
      right = right.next;
    }

    while (right!= null){
      left = left.next;
      right = right.next;
    }

    left.next = left.next.next;

    return dummy.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DeleteKthLastFromList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
