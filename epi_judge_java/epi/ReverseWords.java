package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;
public class ReverseWords {
/*
idea: 5
Imp: 17
 */
  public static void reverseWords(char[] input) {
    int n = input.length;
    reverse(input, 0, n-1);

    int st = 0, end = 0;
    for(int i=0;i<n;i++){
      if(i == input.length-1){
        end = i;
        reverse(input, st, end);
        break;
      }

      if(input[i] == ' '){
        end = i-1;
        reverse(input, st, end);
        st = i+1;
      }
    }

    return;
  }

  private static void reverse(char[] input, int left, int right) {
    while (left<right){
      char temp = input[left];
      input[left++] = input[right];
      input[right--] = temp;
    }
  }


  @EpiTest(testDataFile = "reverse_words.tsv")
  public static String reverseWordsWrapper(TimedExecutor executor, String s)
      throws Exception {
    char[] sCopy = s.toCharArray();

    executor.run(() -> reverseWords(sCopy));

    return String.valueOf(sCopy);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseWords.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
