package epi;
import epi.test_framework.BinaryTreeUtils;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;
public class LowestCommonAncestor {
  public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> root,
                                            BinaryTreeNode<Integer> node0,
                                            BinaryTreeNode<Integer> node1) {
    if(root == null) return null;
    if(root.data == node0.data) return node0;
    if(root.data == node1.data) return node1;

    BinaryTreeNode left = LCA(root.left, node0, node1);
    BinaryTreeNode right = LCA(root.right, node0, node1);

    if(left== null && right==null) return null;
    if(left!=null && right!=null) {
      if ((left.data == node0.data || left.data == node1.data) &&
              (right.data == node0.data || right.data == node1.data)) return root;
      if (left.data == node0.data || left.data == node1.data) return left;
      if (right.data == node0.data || right.data == node1.data) return right;
    }
    if(left!=null) return left;
    if(right!=null) return right;


    return null;
  }
  @EpiTest(testDataFile = "lowest_common_ancestor.tsv")
  public static int lcaWrapper(TimedExecutor executor,
                               BinaryTreeNode<Integer> tree, Integer key0,
                               Integer key1) throws Exception {
    BinaryTreeNode<Integer> node0 = BinaryTreeUtils.mustFindNode(tree, key0);
    BinaryTreeNode<Integer> node1 = BinaryTreeUtils.mustFindNode(tree, key1);

    BinaryTreeNode<Integer> result =
        executor.run(() -> LCA(tree, node0, node1));

    if (result == null) {
      throw new TestFailure("Result can not be null");
    }
    return result.data;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LowestCommonAncestor.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
