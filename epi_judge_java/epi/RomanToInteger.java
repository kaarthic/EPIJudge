package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;

public class RomanToInteger {
  @EpiTest(testDataFile = "roman_to_integer.tsv")

  /*
  I: 5
  Imp:20
   */
  public static int romanToInteger(String s) {
    int n = s.length();
    int total = 0;
    HashMap<Character, Integer> hm = new HashMap();
    hm.put('I',1);
    hm.put('V',5);
    hm.put('X',10);
    hm.put('L',50);
    hm.put('C',100);
    hm.put('D',500);
    hm.put('M',1000);
    for(int i=0;i<s.length()-1;i++){
      char ch = s.charAt(i);
      if(s.charAt(i) == 'V' || s.charAt(i) == 'L' || s.charAt(i) == 'D' || s.charAt(i) == 'M'){
        total+=hm.get(ch);
      }else if(ch == 'I'){
          if(s.charAt(i+1) == 'V' ||s.charAt(i+1) == 'X'){
            total-=hm.get(ch);
          }else{
            total+=hm.get(ch);
          }
      }else if(ch == 'X'){
        if(s.charAt(i+1) == 'L' ||s.charAt(i+1) == 'C'){
          total-=hm.get(ch);
        }else{
          total+=hm.get(ch);
        }
      }else if(ch == 'C'){
        if(s.charAt(i+1) == 'D' ||s.charAt(i+1) == 'M'){
          total-=hm.get(ch);
        }else{
          total+=hm.get(ch);
        }
      }
    }

    total+=hm.get(s.charAt(s.length()-1));
    return total;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RomanToInteger.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
