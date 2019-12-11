package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SortedListsMerge {
  @EpiTest(testDataFile = "sorted_lists_merge.tsv")
  //@include
  public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                      ListNode<Integer> L2) {

    ListNode<Integer> dummyHead = new ListNode<>(0,null);
    ListNode<Integer> current  = dummyHead;
    ListNode<Integer> p1 = L1;
    ListNode<Integer> p2 = L2;

    while (p1!=null && p2!=null){
      if(p1.data<=p2.data){
        current.next = p1;
        p1 = p1.next;

      }else{
        current.next = p2;
        p2 = p2.next;
      }

      current = current.next;
    }

    if(p1!=null) current.next = p1;
    if(p2!=null) current.next = p2;
    return dummyHead.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
