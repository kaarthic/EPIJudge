package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
public class RunLengthCompression {
/*
Idea: 5
Imp:20
 */
  public static String decoding(String s) {
    StringBuilder sb = new StringBuilder();
    int number = 0;
    for(int i=0;i<s.length();i++){
      if(Character.isDigit(s.charAt(i))) number = (number*10)+(s.charAt(i)-'0');
      else {
        while (number>0) {
          sb.append(s.charAt(i));
          number--;
        }
      }
    }
    System.out.println(sb.toString());
    return sb.toString();
  }
  public static String encoding(String s) {
    StringBuilder sb = new StringBuilder();
    int count = 0;

    for(int i=0;i<s.length();i++){
      if(i == s.length()-1 || s.charAt(i)!=s.charAt(i+1)){
        sb.append(count);
        sb.append(s.charAt(i));
      }else count++;
    }
    return sb.toString();
  }
  @EpiTest(testDataFile = "run_length_compression.tsv")
  public static void rleTester(String encoded, String decoded)
      throws TestFailure {
    if (!decoding(encoded).equals(decoded)) {
      throw new TestFailure("Decoding failed");
    }
    if (!encoding(decoded).equals(encoded)) {
      throw new TestFailure("Encoding failed");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RunLengthCompression.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
