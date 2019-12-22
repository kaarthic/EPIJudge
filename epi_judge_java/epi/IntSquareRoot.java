package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IntSquareRoot {
  @EpiTest(testDataFile = "int_square_root.tsv")


/*
Alternate implementation:https://leetcode.com/problems/valid-perfect-square/submissions/
https://leetcode.com/problems/sqrtx/
Corner test case 2 and 12
 */
  public  static int squareRoot(int k) {
    if(k<2) return k;// 0 and 1 sq root is 0 and 1
    long left = 2, right = k/2; //should either start with [0,k] or [2, k/2] (fails for input: 2)


    while (left<right-1) {
      long mid = left+(right-left)/2;//to avoid the overflow
      long sq = mid*mid;//To avoid the overflow
      //System.out.println(left+" :: "+right+" :: "+mid+" :: "+mid*mid);

      if (sq > k) {
        right = mid - 1;
      } else if (sq < k) {
        left = mid;
      } else {
        return (int)mid;
      }
    }

    //if(left*left == k) return (int)left;
    //if(right*right == k) return (int)right;

    //NOTE: Since R>L always -> check the R to be <= k first and then left
    return (right*right<=k)? (int)right:(int)left;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntSquareRoot.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
