package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsStringPalindromicPunctuation {
  @EpiTest(testDataFile = "is_string_palindromic_punctuation.tsv")

  public static boolean isPalindrome(String s) {
    /*
    Idea:5
    Implementation:10
     */
    int left = 0, right = s.length()-1;

    while(left<right){
      /*
      if left or right is not a letter or digit, increment left or decrement right
      else both the left and right is valid entry to compare
       */
      if(!Character.isLetterOrDigit(s.charAt(left))) left++;
      else if(!Character.isLetterOrDigit(s.charAt(right))) right--;
      else{
        if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--)))return false;
      }

    }
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsStringPalindromicPunctuation.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
