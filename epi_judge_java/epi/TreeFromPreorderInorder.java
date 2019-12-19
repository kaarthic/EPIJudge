package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class TreeFromPreorderInorder {
  @EpiTest(testDataFile = "tree_from_preorder_inorder.tsv")

  public static BinaryTreeNode<Integer>
  binaryTreeFromPreorderInorder(List<Integer> preorder, List<Integer> inorder) {

    return binaryTreeFromPreorderInorder(preorder, inorder, 0, preorder.size()-1);
  }
/*
refer to https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution
 */
  private static BinaryTreeNode<Integer> binaryTreeFromPreorderInorder(List<Integer> preorder, List<Integer> inorder, int left, int right) {
    if(left>right) return null;
    BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorder.get(preOrderIdx));
    if(left==right) return root;
    int inOrderidx = findEleInorder(inorder, root.data);
    preOrderIdx++;
    root.left = binaryTreeFromPreorderInorder(preorder, inorder, left, inOrderidx-1);
    root.right = binaryTreeFromPreorderInorder(preorder, inorder, inOrderidx+1, right);

    return root;
  }

  private static int findEleInorder(List<Integer> inorder, Integer data) {
    for(int i=0;i<inorder.size();i++){
      if(inorder.get(i) == data) return i;
    }
    return -1;
  }


   static int preOrderIdx = 0;

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeFromPreorderInorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
