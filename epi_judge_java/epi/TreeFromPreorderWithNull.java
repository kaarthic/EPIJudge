package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;
import java.util.ArrayList;
import java.util.List;
public class TreeFromPreorderWithNull {
  private static int preOrderIdx;

  public static BinaryTreeNode<Integer>
  reconstructPreorder(List<Integer> preorder) {
    preOrderIdx = 0;
    return reconstructPreorderSubTree(preorder);

  }

  private static BinaryTreeNode<Integer> reconstructPreorderSubTree(List<Integer> preorder) {
    Integer curr = preorder.get(preOrderIdx);
    ++preOrderIdx;
    if(curr == null) return null;
    BinaryTreeNode<Integer> left = reconstructPreorder(preorder);
    BinaryTreeNode<Integer> right = reconstructPreorder(preorder);
    return new BinaryTreeNode<>(curr, left, right);
  }

  @EpiTest(testDataFile = "tree_from_preorder_with_null.tsv")
  public static BinaryTreeNode<Integer>
  reconstructPreorderWrapper(TimedExecutor executor, List<String> strings)
      throws Exception {
    List<Integer> ints = new ArrayList<>();
    for (String s : strings) {
      if (s.equals("null")) {
        ints.add(null);
      } else {
        ints.add(Integer.parseInt(s));
      }
    }

    return executor.run(() -> reconstructPreorder(ints));
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeFromPreorderWithNull.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
