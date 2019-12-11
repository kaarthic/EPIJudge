package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;
public class DeleteFromList {

  // Delete the node immediately following aNode. Assumes aNode is not a tail.
  public static void deleteList(ListNode<Integer> aNode) {
    aNode.data = aNode.next.data;
    aNode.next = aNode.next.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DeleteFromList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
