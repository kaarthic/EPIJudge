package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeBalanced {

  @EpiTest(testDataFile = "is_tree_balanced.tsv")


  public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
    return isBalancedHelper(tree).isBalanced;
  }

  public static Balancedheight isBalancedHelper(BinaryTreeNode<Integer> tree) {
    if(tree == null) return new Balancedheight(true, -1);

    Balancedheight left = isBalancedHelper(tree.left);
    if(!left.isBalanced) return new Balancedheight(false, -1);

    Balancedheight right = isBalancedHelper(tree.right);
    if(!right.isBalanced) return new Balancedheight(false, -1);

    boolean isRootBalanced = Math.abs(left.height - right.height) <=1;
    int rootHeight = Math.max(left.height, right.height)+1;

    return new Balancedheight(isRootBalanced, rootHeight);

  }



  static class Balancedheight{
    boolean isBalanced;
    int height;

    public Balancedheight(boolean isBalanced, int height){
      this.isBalanced = isBalanced;
      this.height = height;
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeBalanced.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
