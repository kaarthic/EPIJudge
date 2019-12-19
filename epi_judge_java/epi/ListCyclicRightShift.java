package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ListCyclicRightShift {
  @EpiTest(testDataFile = "list_cyclic_right_shift.tsv")

  public static ListNode<Integer> cyclicallyRightShiftList(ListNode<Integer> L,
                                                           int k) {

    //1,2,3,4,5,6,7
    /*
    imple: 16 min
    Things to note: length k can go beyond the length. To convert the k within the length bounds, k = k%len;
    the second cut piece can be null. Handle that case
    input can be null
     */
    if(L == null) return null;
    ListNode<Integer> dummy = new ListNode<>(0, null);
    dummy.next = L;

    int len = 0;
    ListNode<Integer> lenPtr = L;
    while (lenPtr!=null){
      len++;
      lenPtr = lenPtr.next;
    }
    //to handle k> listnode.length
    k = k%len;
    int hops = len-k;
    while (hops-->0){
      dummy = dummy.next;
    }

    ListNode<Integer> second = dummy.next;
    if(second == null) {
      //there is nothing to cut, hence return original list
      return L;
    }
    dummy.next = null;

    ListNode<Integer> secPtr = second;
    while (secPtr.next!=null){
      secPtr = secPtr.next;
    }

    secPtr.next = L;


    return second;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ListCyclicRightShift.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
