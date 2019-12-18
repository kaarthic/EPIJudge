package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeInorder {
  @EpiTest(testDataFile = "tree_inorder.tsv")

  public static List<Integer> inorderTraversal(BinaryTreeNode<Integer> tree) {
    List<Integer> result = new ArrayList<>();
    Stack<BinaryTreeNode> st = new Stack<>();

    //visit left subtree
    BinaryTreeNode<Integer> curr = tree;
    while (curr!=null){
      st.push(curr);
      curr = curr.left;
    }

    /*
    1. visit current
    2. visit left subtree of right
     */
    while (!st.isEmpty()) {
      curr = st.pop();
      result.add(curr.data);

      curr = curr.right;
      while (curr != null) {
        st.push(curr);
        curr = curr.left;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeInorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
