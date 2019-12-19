package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.*;

public class TreeConnectLeaves {

  public static List<BinaryTreeNode<Integer>>
  createListOfLeaves(BinaryTreeNode<Integer> tree) {
    //Unequal levels will have unexpected result
    /*List<BinaryTreeNode<Integer>> result = new ArrayList<>();
    if(tree == null) return result;
    Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
    q.add(tree);

    while (!q.isEmpty()){
      int size = q.size();
      while (size-->0){
        BinaryTreeNode<Integer> curr = q.poll();
        if(size>0){
          //curr.next = q.peek();
        }
       if(curr.left == null && curr.right==null) result.add(curr);
        if(curr.left!=null) q.add(curr.left);
        if(curr.right!=null) q.add(curr.right);
      }

    }
    //Collections.reverse(result);
    return result;*/
    List<BinaryTreeNode<Integer>> result = new ArrayList<>();
    createListOfLeavesHelper(tree, result);
    return result;
  }

  private static void createListOfLeavesHelper(BinaryTreeNode<Integer> tree, List<BinaryTreeNode<Integer>> result) {
    if(tree == null) return;


    createListOfLeavesHelper(tree.left, result);

    createListOfLeavesHelper(tree.right, result);

    if(tree.left == null && tree.right==null) {
      result.add(tree); return;
    }
    //NOTE: Any of the three traversal would work, since the order in which the leaves are visited is left -> right
  }

  @EpiTest(testDataFile = "tree_connect_leaves.tsv")
  public static List<Integer>
  createListOfLeavesWrapper(TimedExecutor executor,
                            BinaryTreeNode<Integer> tree) throws Exception {
    List<BinaryTreeNode<Integer>> result =
        executor.run(() -> createListOfLeaves(tree));

    if (result.stream().anyMatch(x -> x == null || x.data == null)) {
      throw new TestFailure("Result can't contain null");
    }

    List<Integer> extractedRes = new ArrayList<>();
    for (BinaryTreeNode<Integer> x : result) {
      extractedRes.add(x.data);
    }
    return extractedRes;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeConnectLeaves.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
