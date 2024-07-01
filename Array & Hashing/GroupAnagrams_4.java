import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_4 {

  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    HashMap<String, List<String>> maps = new HashMap<String, List<String>>();

    for (int i = 0; i < strs.length; i++) {
      String s = strs[i];

      char[] charArray = s.toCharArray();

      Arrays.sort(charArray);

      String r = new String(charArray);

      List<String> templist = maps.get(r);
      if (templist == null) {
        templist = new ArrayList<>();
        templist.add(s);
        result.add(templist);
      } else {
        templist.add(s);
      }

      maps.put(r, templist);
    }

    return result;
  }

  public static void main(String[] args) {
    String[] test = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
    System.out.println(groupAnagrams(test));
  }
}
