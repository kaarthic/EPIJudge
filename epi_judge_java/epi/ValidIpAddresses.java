package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.EpiTestComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
public class ValidIpAddresses {
  @EpiTest(testDataFile = "valid_ip_addresses.tsv")

  public static List<String> getValidIpAddress(String s) {
    List<String> ipAddresses = new ArrayList<>();
    String ipAddress = "";
    int part = 1;
    int sIdx = 0;
    getValidIpAddress(s,sIdx,part,ipAddress,ipAddresses);
    return ipAddresses;
  }

  private static void getValidIpAddress(String s, int sIdx, int part, String ipAddress, List<String> ipAddresses) {
    if(part == 5 && sIdx == s.length()){
      System.out.println("---"+ipAddress.substring(0,ipAddress.length()-1));
      ipAddresses.add(ipAddress.substring(0,ipAddress.length()-1));
      return;
    }

    if(part == 5 && sIdx!=s.length()) return;
    if(sIdx == s.length() && part != 5) return;

    for(int i=sIdx+1;i<s.length();i++){
      String partCand = s.substring(sIdx,i);
      if(!isValid(partCand)){
        System.out.println();
        return;
      }
      //if(isValid(partCand))
      getValidIpAddress(s,i, part+1, ipAddress+partCand+".",ipAddresses);
    }

  }

  private static boolean isValid(String partCand) {
    if(partCand.length() > 3) return false;
    if(partCand.charAt(0)=='0' && partCand.length()>1) return false;
    int val = Integer.parseInt(partCand);
    return val>=0 && val<=255;
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
            .runFromAnnotations(args, "ValidIpAddresses.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
