package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
public class StringIntegerInterconversion {

  /*
  Fails for
  Arguments
	arg0: -2147483648
	arg1: -2147483648

   */
  public static String intToString(int x) {
    if(x==0) return "0";
    boolean isNegative = false;
    if(x<0){
      isNegative = true;
      x = Math.abs(x);
    }

    StringBuilder sb = new StringBuilder();
    while(x!=0){
      sb.append(x%10);
      x=x/10;
    }

    if(isNegative){
      sb.append("-");
    }
    sb.reverse();

    return sb.toString();
  }
  public static int stringToInt(String s) {
    int startIndex = (s.charAt(0) == '-')?1:0;
    int number = 0;

    for(int i=startIndex;i<s.length();i++){
      number = number*10+(s.charAt(i)-'0');
    }

    if(startIndex==1) return -1*number;
    return number;
  }
  @EpiTest(testDataFile = "string_integer_interconversion.tsv")
  public static void wrapper(int x, String s) throws TestFailure {
    if (!intToString(x).equals(s)) {
      throw new TestFailure("Int to string conversion failed");
    }
    if (stringToInt(s) != x) {
      throw new TestFailure("String to int conversion failed");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "StringIntegerInterconversion.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
