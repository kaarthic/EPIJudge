package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsListPalindromic {
  @EpiTest(testDataFile = "is_list_palindromic.tsv")
/*
Imp: 30 minutes
 */
  public static boolean isLinkedListAPalindrome(ListNode<Integer> L) {
    //1 2 3 4 5 6 NULL
    //1 2 3 4 5 NULL

    if(L == null) return true;
    ListNode<Integer> slow = L;
    ListNode<Integer> fast = L;

    while(fast!=null && fast.next!=null){
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode<Integer> second = reverseList(slow.next);
    slow.next = null;

    slow = L;

    while(slow!=null && second!=null){
      if(slow.data != second.data) return false;
      slow = slow.next;
      second = second.next;
    }
    return true;
  }

  private static ListNode<Integer> reverseList(ListNode<Integer> head) {
    ListNode<Integer> prev = null;
    ListNode<Integer> curr = head;

    while(curr!=null) {
      ListNode<Integer> temp = curr.next;
      curr.next = prev;

      prev = curr;
      curr = temp;

    }
    return prev;

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsListPalindromic.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
