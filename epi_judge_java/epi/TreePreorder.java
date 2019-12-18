package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreePreorder {
  @EpiTest(testDataFile = "tree_preorder.tsv")

  public static List<Integer> preorderTraversal(BinaryTreeNode<Integer> tree) {
    List<Integer> result = new ArrayList<>();
    Stack<BinaryTreeNode> st = new Stack<>();

    st.add(tree);

    /*
    visit root
    process left and right
     */
    while (!st.isEmpty()) {
      BinaryTreeNode<Integer> curr = st.pop();
      if(curr!=null) {
        result.add(curr.data);
        st.push(curr.right);//push null nodes as well and check for not null before processing
        st.push(curr.left);
      }
    }


    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreePreorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
