import java.util.HashMap;

/**
 * 2validAnagram
 */
public class validAnagram_2 {

  public static boolean isAnagram(String s, String t) {
    HashMap<Character, Integer> unique = new HashMap<Character, Integer>();

    if (s.length() != t.length()) return false;

    for (int i = 0; i < s.length(); i++) {
      int value = 0;
      if (unique.get(s.charAt(i)) != null) value = unique.get(s.charAt(i));
      unique.put(s.charAt(i), value + 1);
    }

    for (int i = 0; i < t.length(); i++) {
      int value = 0;
      if (unique.get(t.charAt(i)) != null) value = unique.get(t.charAt(i));
      if (value > 0) unique.put(t.charAt(i), value - 1); else return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isAnagram("caaaat", "taaaca"));
  }
}
