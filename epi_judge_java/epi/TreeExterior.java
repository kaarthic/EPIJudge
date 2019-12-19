package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class TreeExterior {
/*
https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 */
  public static List<BinaryTreeNode<Integer>>
  exteriorBinaryTree(BinaryTreeNode<Integer> tree) {
    List<BinaryTreeNode<Integer>> result = new ArrayList<>();
    if(tree == null) return result;
    result.add(tree);
    exploreLeftBoundary(tree.left, result);// WARNING: exploreLeftBoundary(tree, result); would duplicate count the root
    /*
    Arguments
	arg1:     ["2"]

Failure info
	expected: [2]
	result:   [2, 2]
	if
	exploreBottomBoundary(tree, result);
     */
    exploreBottomBoundary(tree.left, result);
    exploreBottomBoundary(tree.right, result);
    exploreRightBoundary(tree.right, result);// WARNING: exploreRightBoundary(tree, result); would duplicate count the root
    return result;
  }

  private static void exploreRightBoundary(BinaryTreeNode<Integer> tree, List<BinaryTreeNode<Integer>> result) {
    if(tree == null) return;

    if(tree.right!=null){
      exploreRightBoundary(tree.right, result);
      result.add(tree);
    }else if(tree.left!=null){
      exploreRightBoundary(tree.left, result);
      result.add(tree);
    }
  }

  private static void exploreBottomBoundary(BinaryTreeNode<Integer> tree, List<BinaryTreeNode<Integer>> result) {
    if(tree == null) return;

    if(tree.left == null && tree.right == null) result.add(tree);
    exploreBottomBoundary(tree.left, result);
    exploreBottomBoundary(tree.right, result);
  }

  private static void exploreLeftBoundary(BinaryTreeNode<Integer> tree, List<BinaryTreeNode<Integer>> result) {
    if(tree == null) return;

    if(tree.left!=null){
      result.add(tree);
      exploreLeftBoundary(tree.left, result);
    }else if(tree.right!=null){
      result.add(tree);
      exploreLeftBoundary(tree.right, result);
    }
  }

  private static List<Integer> createOutputList(List<BinaryTreeNode<Integer>> L)
      throws TestFailure {
    if (L.contains(null)) {
      throw new TestFailure("Resulting list contains null");
    }
    List<Integer> output = new ArrayList<>();
    for (BinaryTreeNode<Integer> l : L) {
      output.add(l.data);
    }
    return output;
  }

  @EpiTest(testDataFile = "tree_exterior.tsv")
  public static List<Integer>
  exteriorBinaryTreeWrapper(TimedExecutor executor,
                            BinaryTreeNode<Integer> tree) throws Exception {
    List<BinaryTreeNode<Integer>> result =
        executor.run(() -> exteriorBinaryTree(tree));

    return createOutputList(result);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeExterior.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
