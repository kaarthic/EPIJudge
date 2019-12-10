package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class LookAndSay {
  @EpiTest(testDataFile = "look_and_say.tsv")
/*
I: 5
Imp: 20
 */
  public static String lookAndSay(int n) {
    String s = "1";

    for(int i=2;i<=n;i++){
      s = nextNumber(s);
    }
    return s;
  }

  private static String nextNumber(String s) {
    int count = 1;
    char ch = s.charAt(0);
    StringBuilder sb = new StringBuilder();
    for(int i=1;i<s.length();i++){
      if(s.charAt(i-1) == s.charAt(i)) count++;
      else{
        sb.append(count).append(ch);
        count = 1;
        ch = s.charAt(i);
      }
    }

    sb.append(count).append(ch);
    return sb.toString();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LookAndSay.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
