package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeSymmetric {
  @EpiTest(testDataFile = "is_tree_symmetric.tsv")

  public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
    if(tree == null) return true;

    return isSymmetric(tree.left, tree.right);
  }

  private static boolean isSymmetric(BinaryTreeNode<Integer> tree1, BinaryTreeNode<Integer> tree2) {
    if(tree1 == null && tree2 == null) return true;
    else if(tree1 != null && tree2 != null){
      return (tree1.data == tree2.data)&&isSymmetric(tree1.left , tree2.right)&&isSymmetric(tree1.right,tree2.left);
    }else return false;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeSymmetric.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
