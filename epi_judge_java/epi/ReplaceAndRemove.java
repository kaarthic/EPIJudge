package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;
import java.util.ArrayList;
import java.util.List;
public class ReplaceAndRemove {

  public static int replaceAndRemove(int size, char[] s) {
    /*
    Idea: 20 min
    Implement: 40 min
     */
    System.out.println();
    // TODO - you fill in here.
    //b->''
    //a->dd
   /* The below algo wont work when aCount <= bCount. To make aCount > bCount, delete b from the string
   int aCount = 0, bCount = 0;
    for(int i=0;i<size;i++){
      if(s[i]=='a') aCount++;
      if(s[i]=='b') bCount++;
    }
    int finalPos = size-1+aCount-bCount;
    int finalSize = finalPos+1;
    int write = finalPos;
    for(int i=size-1;i>=0;i--){
      if(s[i] == 'a'){
        s[write--] = 'd';
        s[write--] = 'd';
      }else if(s[i]=='b'){

      }else {
        s[write--] = s[i];
      }
    }
    return finalSize;*/

   int aCount = 0;
   int write = 0;
   for(int i=0;i<size;i++){
     //write only non b
     if(s[i] == 'a') aCount++;
     if(s[i] != 'b'){
       s[write++] = s[i];
     }

   }

   //wrong int finalPos = size-1+aCount; int finalSize = finalPos+1;
    int finalSize = write+aCount;
    int fin = finalSize-1;
   for(int i=write-1;i>=0;i--){
     if(s[i] == 'a') {
       s[fin--] = 'd';
       s[fin--] = 'd';
     }else {
       s[fin--] = s[i];
     }
   }

   return finalSize;

  }
  @EpiTest(testDataFile = "replace_and_remove.tsv")
  public static List<String>
  replaceAndRemoveWrapper(TimedExecutor executor, Integer size, List<String> s)
      throws Exception {
    char[] sCopy = new char[s.size()];
    for (int i = 0; i < size; ++i) {
      if (!s.get(i).isEmpty()) {
        sCopy[i] = s.get(i).charAt(0);
      }
    }

    Integer resSize = executor.run(() -> replaceAndRemove(size, sCopy));

    List<String> result = new ArrayList<>();
    for (int i = 0; i < resSize; ++i) {
      result.add(Character.toString(sCopy[i]));
    }
    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReplaceAndRemove.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
