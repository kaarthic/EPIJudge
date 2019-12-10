package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
public class PhoneNumberMnemonic {
  @EpiTest(testDataFile = "phone_number_mnemonic.tsv")
/*
IDea: 15 Minutes
Code: 28 Minutes
 */
  public static List<String> phoneMnemonic(String phoneNumber) {
    List<String> mnemonics = new ArrayList<>();
    int index = 0;
    String mnemonic = "";
    phoneMnemonic(phoneNumber, index, mnemonic,mnemonics);
    return mnemonics;
  }

  private static final String[] MAPPING = {"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
  private static void phoneMnemonic(String phoneNumber, int index, String mnemonic, List<String> mnemonics) {
    if(index == phoneNumber.length()){
        mnemonics.add(mnemonic);
        //WARNING DO NOT FORGET THIS RETURN STATEMENT
        return;
    }

    String selection = MAPPING[phoneNumber.charAt(index)-'0'];
    for(int i=0;i<selection.length();i++){
      phoneMnemonic(phoneNumber, index+1, mnemonic+selection.charAt(i), mnemonics);
    }
  }


  @EpiTestComparator
  public static BiPredicate<List<String>, List<String>> comp =
      (expected, result) -> {
    if (result == null) {
      return false;
    }
    Collections.sort(expected);
    Collections.sort(result);
    return expected.equals(result);
  };

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PhoneNumberMnemonic.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
