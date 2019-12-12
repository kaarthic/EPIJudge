package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IntAsListAdd {
  @EpiTest(testDataFile = "int_as_list_add.tsv")
/*
Imp: 18 min
 */
  public static ListNode<Integer> addTwoNumbers(ListNode<Integer> L1,
                                                ListNode<Integer> L2) {
    ListNode<Integer> l1Head = L1;
    ListNode<Integer> l2Head = L2;
    ListNode<Integer> res = new ListNode<>(0,null);
    ListNode<Integer> resPtr = res;
    int carry = 0;
    while (l1Head!=null || l2Head!=null){
      int sum = carry;
      if(l1Head!=null){
        sum+=l1Head.data;
        l1Head = l1Head.next;
      }

      if(l2Head!=null){
        sum+=l2Head.data;
        l2Head = l2Head.next;
      }

      carry = sum/10;
      sum = sum%10;

      resPtr.next = new ListNode<>(sum, null);
      resPtr = resPtr.next;

    }

    if(carry != 0){
      resPtr.next = new ListNode<>(carry, null);
      resPtr = resPtr.next;
    }
    return res.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsListAdd.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
