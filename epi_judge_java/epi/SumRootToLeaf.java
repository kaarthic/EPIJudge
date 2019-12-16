package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SumRootToLeaf {
  @EpiTest(testDataFile = "sum_root_to_leaf.tsv")

  public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
    return sumNumbers(tree, 0);
  }
  public static int sumNumbers(BinaryTreeNode<Integer> root, int runningSum) {
    if(root == null) return 0;

    runningSum = runningSum*2+root.data;
    if(root.left==null && root.right==null) return runningSum;

    int leftSum = sumNumbers(root.left, runningSum);
    int rightSum = sumNumbers(root.right, runningSum);

    return leftSum+rightSum;
  }
  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SumRootToLeaf.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
